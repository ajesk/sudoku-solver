package io.acode.sudoku_solver.model;

import junit.framework.TestCase;

public class TestCell extends TestCase {
    public void testUnsolvedInit() {
        Cell cell = new Cell();
        assert(cell.getValues().size() == 9);
        assert(!cell.isSolved());
    }

    public void testSolvedInit() {
        Cell cell = new Cell();
        cell.init(1);
        assert(cell.getValues().size() == 1);
        assert(cell.isSolved());
    }

    public void testRemoveValue() {
        Cell cell = new Cell();
        cell.removeValue(6);
        assert cell.getValues().size() == 8;
        assert !cell.getValues().contains(6);
        cell.removeValue(4);
        assert cell.getValues().size() == 7;
        assert !cell.getValues().contains(4);
    }

    public void testSolveCell() {
        Cell cell = new Cell();
        for (int i = 1; i < 9; i++) {
            cell.removeValue(i);
        }
        assertEquals(1, cell.getValues().size());
        assert cell.isSolved();
    }
}