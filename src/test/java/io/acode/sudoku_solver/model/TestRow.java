package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;

public class TestRow extends TestCase {
    private Grid loadDemo() {
        return DemoGridLoader.getDemoGrid();
    }

    public void testCleanRow() {
        Grid grid = loadDemo();
        Row row = grid.getRow(0);
        row.forEach(cell -> {
            assert cell.getValues().contains(2) || cell.isSolved();
            assert cell.getValues().contains(4) || cell.isSolved();
        });
        row.clean(2);
        row.clean(4);
        row.forEach(cell -> {
            assert !cell.getValues().contains(2);
            assert !cell.getValues().contains(4) || cell.isSolved();
        });

        Row row2 = grid.getRow(5);
        row2.forEach(cell -> {
            assert cell.getValues().contains(9) || cell.isSolved();
            assert cell.getValues().contains(1) || cell.isSolved();
        });
        row2.clean(1);
        row2.clean(9);
        row2.forEach(cell -> {
            assert !cell.getValues().contains(9);
            assert !cell.getValues().contains(1) || cell.isSolved();
        });
    }

    public void testValueIsUnique() {
        Grid grid = loadDemo();
        Row row = grid.getRow(0);
        assert !row.valueIsUnique(9);
        row.forEach(cell -> cell.init(5));
        row.get(4).init(1);
        assert row.valueIsUnique(1);

        Row row2 = grid.getRow(8);
        row2.clean(7);
        row2.get(7).init();
        assert row2.valueIsUnique(7);
        assert row2.get(7).getValues().contains(7);
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
