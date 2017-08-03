package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;

public class TestBox extends TestCase {
    private Grid loadDemo() {
        return DemoGridLoader.getDemoGrid();
    }

    public void testCleanBox() {
        Grid grid = loadDemo();
        Box box = grid.getBox(2, 0);
        box.forEach(cell -> {
            assert cell.getValues().contains(4) || cell.isSolved();
            assert cell.getValues().contains(6) || cell.isSolved();
        });
        box.clean(4);
        box.clean(6);
        box.forEach(cell -> {
            assert !cell.getValues().contains(4);
            assert !cell.getValues().contains(6) || cell.isSolved();
        });

        Box box2 = grid.getBox(7, 7);
        box2.forEach(cell -> {
            assert cell.getValues().contains(1) || cell.isSolved();
            assert cell.getValues().contains(9) || cell.isSolved();
        });

        box2.clean(1);
        box2.clean(9);
        box2.forEach(cell -> {
            assert !cell.getValues().contains(1);
            assert !cell.getValues().contains(9) || cell.isSolved();
        });
    }

    public void testValueIsUnique() {
        Grid grid = loadDemo();
        Box box = grid.getBox(0, 0);
        assert !box.valueIsUnique(9);
        box.forEach(cell -> cell.init(5));
        box.get(4).init(1);
        assert box.valueIsUnique(1);

        Box box2 = grid.getBox(8, 8);
        box2.clean(7);
        box2.get(7).init();
        assert box2.valueIsUnique(7);
        assert box2.get(7).getValues().contains(7);
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
