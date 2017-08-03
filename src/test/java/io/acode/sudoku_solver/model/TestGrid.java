package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;

public class TestGrid extends TestCase {
    private Grid loadDemo() {
        return DemoGridLoader.getDemoGrid();
    }

    public void testRowContainsDuplicates() {
        Grid grid = loadDemo();
        assert grid.rowContainsDuplicates(0, 4);
        grid.getRow(0).forEach(cell -> cell.init(1));
        grid.getRow(0).get(4).init(5);
        assert !grid.rowContainsDuplicates(0, 5);
        grid.getRow(2).forEach(cell -> cell.init(7));
        grid.getRow(2).get(3).init(8);
        assert !grid.rowContainsDuplicates(2, 8);
    }

    public void testColumnContainsDuplicates() {
        Grid grid = loadDemo();
        assert grid.columnContainsDuplicates(0, 2);
        grid.getColumn(0).forEach(cell -> cell.init(1));
        grid.getColumn(0).get(6).init(6);
        assert !grid.columnContainsDuplicates(0, 6);
        grid.getColumn(4).forEach(cell -> cell.init(7));
        grid.getColumn(4).get(5).init(2);
        assert !grid.columnContainsDuplicates(4, 2);
    }

    public void testBoxContainsDuplicates() {
        Grid grid = loadDemo();
        assert grid.boxContainsDuplicates(0, 0, 4);
        grid.getBox(0,0).forEach(cell -> cell.init(1));
        grid.getBox(0,0).get(3).init(4);
        assert !grid.boxContainsDuplicates(0,0,4);
        assert grid.boxContainsDuplicates(0,0,1);
        grid.getBox(8,8).forEach(cell -> cell.init(1));
        grid.getBox(8,8).get(6).init(8);
        assert !grid.boxContainsDuplicates(8,8,8);
        assert grid.boxContainsDuplicates(8,8,1);
    }

    public void testValueIsUnique() {
        Grid grid = loadDemo();
        assert !grid.valueIsUnique(3, 3, 5);
        grid.getBox(3,3).forEach(cell -> cell.init(1));
        grid.getColumn(3).forEach(cell -> cell.init(1));
        grid.getRow(3).forEach(cell -> cell.init(1));
        grid.getCell(3, 3).init(5);
        assert grid.valueIsUnique(3, 3, 5);
    }

    public void testToString() {
        Grid grid = loadDemo();
        System.out.println(grid);
    }
}
