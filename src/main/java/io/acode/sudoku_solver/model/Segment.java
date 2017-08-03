package io.acode.sudoku_solver.model;

import java.util.ArrayList;

/**
 * Parent class of row, column, or box
 */
class Segment extends ArrayList<Cell> {
    final void clean(int val) {
        this.forEach(cell -> cell.removeValue(val));
    }

    final boolean valueIsUnique(int val) {
        return this.stream().filter(cell -> cell.getValues().contains(val)).count() == 1;
    }
}
