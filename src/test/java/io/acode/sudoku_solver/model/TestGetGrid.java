package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Test cases specifically for getting selections from a grid
 */
public class TestGetGrid extends TestCase {
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
        assertEquals(1, grid.getCell(4,0).getValues().get(0).intValue());
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
        Grid grid = loadDemo();
        ArrayList<Cell> box = grid.getBox(0, 0);
        assertEquals(9, box.size());
        assertEquals(3, box.get(4).getValues().get(0).intValue());
        assertEquals(2, box.get(5).getValues().get(0).intValue());
        assertEquals(6, box.get(8).getValues().get(0).intValue());
    }

    /**
     * A test to ensure that all three of the get methods match up as intended
     */
    public void testGetAll() {
        Grid grid = loadDemo();
        ArrayList<Cell> box = grid.getBox(4, 5);
        ArrayList<Cell> column = grid.getColumn(4);
        ArrayList<Cell> row = grid.getRow(5);
        Cell cell = grid.getCell(4,5);
        assert cell.getValues().get(0).equals(6);
        assert row.get(3).getValues().get(0) == 1;
        assert row.get(4).getValues().get(0) == 6;
        assert column.get(0).getValues().get(0) == 1;
        assert column.get(3).getValues().get(0) == 7;
        assert column.get(4).getValues().get(0) == 4;
        assert column.get(5).getValues().get(0) == 6;
        assert column.get(8).getValues().get(0) == 2;
        assert box.get(1).getValues().get(0) == 3;
        assert box.get(2).getValues().get(0) == 1;
        assert box.get(3).getValues().get(0) == 7;
        assert box.get(4).getValues().get(0) == 4;
        assert box.get(5).getValues().get(0) == 6;
        assert box.get(6).getValues().get(0) == 5;
        assert box.get(7).getValues().get(0) == 2;
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
