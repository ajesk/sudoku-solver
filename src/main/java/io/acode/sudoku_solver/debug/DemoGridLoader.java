package io.acode.sudoku_solver.debug;

import io.acode.sudoku_solver.model.Grid;

/**
 * Created by aaron on 4/28/17.
 */
public class DemoGridLoader {
    public static Grid getDemoGrid() {
        Grid grid = new Grid();

        grid.getCell(0, 7).init(6);
        grid.getCell(0, 8).init(1);
        grid.getCell(1, 1).init(3);
        grid.getCell(1, 2).init(2);
        grid.getCell(1, 6).init(8);
        grid.getCell(1, 8).init(4);
        grid.getCell(2, 2).init(6);
        grid.getCell(2, 7).init(5);
        grid.getCell(3, 2).init(7);
        grid.getCell(3, 4).init(3);
        grid.getCell(3, 5).init(1);
        grid.getCell(4, 0).init(1);
        grid.getCell(4, 3).init(7);
        grid.getCell(4, 4).init(4);
        grid.getCell(4, 5).init(6);
        grid.getCell(4, 8).init(2);
        grid.getCell(5, 3).init(5);
        grid.getCell(5, 4).init(2);
        grid.getCell(5, 6).init(1);
        grid.getCell(6, 1).init(8);
        grid.getCell(6, 6).init(6);
        grid.getCell(7, 0).init(4);
        grid.getCell(7, 2).init(1);
        grid.getCell(7, 4).init(8);
        grid.getCell(7, 6).init(9);
        grid.getCell(7, 7).init(3);
        grid.getCell(8, 0).init(7);
        grid.getCell(8, 1).init(9);
        return grid;
    }
}
