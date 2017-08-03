package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;

public class TestColumn extends TestCase {
    private Grid loadDemo() {
        return DemoGridLoader.getDemoGrid();
    }

    public void testCleanColumn() {
        Grid grid = loadDemo();
        Column column = grid.getColumn(0);
        column.forEach(cell -> {
            assert cell.getValues().contains(2) || cell.isSolved();
            assert cell.getValues().contains(6) || cell.isSolved();
        });
        column.clean(2);
        column.clean(6);
        column.forEach(cell -> {
            assert !cell.getValues().contains(2);
            assert !cell.getValues().contains(6) || cell.isSolved();
        });

        Column column2 = grid.getColumn(6);
        column2.forEach(cell -> {
            assert cell.getValues().contains(3) || cell.isSolved();
            assert cell.getValues().contains(8) || cell.isSolved();
        });
        column2.clean(3);
        column2.clean(8);
        column2.forEach(cell -> {
            assert !cell.getValues().contains(3);
            assert !cell.getValues().contains(8) || cell.isSolved();
        });
    }

    public void testValueIsUnique() {
        Grid grid = loadDemo();
        Column column = grid.getColumn( 0);
        assert !column.valueIsUnique(9);
        column.forEach(cell -> cell.init(5));
        column.get(4).init(1);
        assert column.valueIsUnique(1);

        Column column2 = grid.getColumn(7);
        column2.clean(7);
        column2.get(7).init();
        assert column2.valueIsUnique(7);
        assert column2.get(7).getValues().contains(7);
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
