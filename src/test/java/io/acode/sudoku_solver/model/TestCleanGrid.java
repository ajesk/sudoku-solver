package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;

import java.util.ArrayList;

public class TestCleanGrid extends TestCase {
    private Grid loadDemo() {
        return DemoGridLoader.getDemoGrid();
    }

    public void testCleanRow() {
        Grid grid = loadDemo();
        ArrayList<Cell> row = grid.getRow(0);
        row.forEach(cell -> {
            assert cell.getValues().contains(2) || cell.isSolved();
        });
        grid.cleanRow(0, 2);
        row.forEach(cell -> {
            assert !cell.getValues().contains(2);
        });
    }

    public void testCleanBox() {
        Grid grid = loadDemo();
        ArrayList<Cell> box = grid.getBox(2, 0);
        box.forEach(cell -> {
            assert cell.getValues().contains(4) || cell.isSolved();
            assert cell.getValues().contains(6) || cell.isSolved();
        });
        grid.cleanBox(0, 0, 4);
        grid.cleanBox(2, 2, 6);
        box.forEach(cell -> {
            assert !cell.getValues().contains(4);
            assert !cell.getValues().contains(6) || cell.isSolved();
        });

        ArrayList<Cell> box2 = grid.getBox(7, 7);
        box2.forEach(cell -> {
            assert cell.getValues().contains(1) || cell.isSolved();
            assert cell.getValues().contains(9) || cell.isSolved();
        });

        grid.cleanBox(8, 6, 1);
        grid.cleanBox(6, 8, 9);
        box2.forEach(cell -> {
            assert !cell.getValues().contains(1);
            assert !cell.getValues().contains(9) || cell.isSolved();
        });
    }

    public void testCleanColumn() {
        Grid grid = loadDemo();
        ArrayList<Cell> column = grid.getColumn(0);
        column.forEach(cell -> {
            assert cell.getValues().contains(2) || cell.isSolved();
            assert cell.getValues().contains(6) || cell.isSolved();
        });
        grid.cleanColumn(0, 2);
        grid.cleanColumn(0, 6);
        column.forEach(cell -> {
            assert !cell.getValues().contains(2);
            assert !cell.getValues().contains(6) || cell.isSolved();
        });

        ArrayList<Cell> column2 = grid.getColumn(6);
        column2.forEach(cell -> {
            assert cell.getValues().contains(3) || cell.isSolved();
            assert cell.getValues().contains(8) || cell.isSolved();
        });
        grid.cleanColumn(6, 2);
        grid.cleanColumn(6, 6);
        column2.forEach(cell -> {
            assert !cell.getValues().contains(2);
            assert !cell.getValues().contains(6) || cell.isSolved();
        });
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
