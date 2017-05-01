package io.acode.sudoku_solver.model;

import lombok.Data;

@Data
public class Grid {
    private Cell[][] grid = new Cell[9][9];

    public Grid() {
        initCells();
    }

    private void initCells() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; x < 9; x++) {
                grid[x][y] = new Cell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void cleanRow(int y, int value) {

    }

    public void cleanColumn(int x, int value) {

    }

    public void cleanBox(int x, int y, int value) {

    }
}
