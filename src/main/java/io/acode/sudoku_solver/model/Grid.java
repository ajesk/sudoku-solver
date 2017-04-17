package io.acode.sudoku_solver.model;

import lombok.Data;

@Data
public class Grid {
    private Cell[][] grid = new Cell[9][9];

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void cleanRow(int value) {

    }
}
