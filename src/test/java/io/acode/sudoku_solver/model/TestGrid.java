package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;

import java.util.ArrayList;

public class TestGrid extends TestCase {
    private Grid loadDemo() {
        return DemoGridLoader.getDemoGrid();
    }

    public void testInit() {
        Grid grid = new Grid();
        assertNotNull(grid);
        assertEquals(9, grid.size());
        assertEquals(9, grid.get(0).size());
    }

    public void testGetCell() {
        Grid grid = loadDemo();
        assertEquals(1, grid.getCell(4,1).getValues().get(0).intValue());
        assertEquals(8, grid.getCell(7,4).getValues().get(0).intValue());
        assertEquals(2, grid.getCell(4,8).getValues().get(0).intValue());
        assertEquals(5, grid.getCell(2,7).getValues().get(0).intValue());
    }

    public void testGetRow() {
        Grid grid = loadDemo();
        ArrayList<Cell> row = grid.getRow(0);
        assertEquals(3, row.stream().filter(Cell::isSolved).count());
        assertEquals(1, row.get(4).getValues().get(0).intValue());
        assertEquals(4, row.get(7).getValues().get(0).intValue());
        assertEquals(7, row.get(8).getValues().get(0).intValue());
    }

    public void testGetColumn() {
        Grid grid = loadDemo();
        ArrayList<Cell> column = grid.getColumn(0);
        assertEquals(2, column.stream().filter(Cell::isSolved).count());
        assertEquals(6, column.get(7).getValues().get(0).intValue());
        assertEquals(1, column.get(8).getValues().get(0).intValue());
    }

    public void testGetBox() {

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
        Grid grid = new Grid();
    }

    public void testCleanColumn() {
        Grid grid = loadDemo();
        ArrayList<Cell> column = grid.getColumn(0);
        column.forEach(cell -> {
            assert cell.getValues().contains(2) || cell.isSolved();
        });
        grid.cleanColumn(0, 2);
        column.forEach(cell -> {
            assert !cell.getValues().contains(2);
        });
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
