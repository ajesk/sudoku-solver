package io.acode.sudoku_solver.debug;

import io.acode.sudoku_solver.model.Cell;
import io.acode.sudoku_solver.model.Grid;

/**
 * Created by aaron on 4/28/17.
 */
public class DemoGridLoader {
    public static Grid getDemoGrid() {
        Grid grid = new Grid();

        Cell[][] cells = grid.getGrid();

        cells[0][0].init();
        cells[0][1].init();
        cells[0][2].init();
        cells[0][3].init();
        cells[0][4].init();
        cells[0][5].init();
        cells[0][6].init();
        cells[0][7].init(6);
        cells[0][8].init(1);

        cells[1][0].init();
        cells[1][1].init(3);
        cells[1][2].init(2);
        cells[1][3].init();
        cells[1][4].init(6);
        cells[1][5].init();
        cells[1][6].init(8);
        cells[1][7].init();
        cells[1][8].init(4);

        cells[2][0].init();
        cells[2][1].init();
        cells[2][2].init(6);
        cells[2][3].init();
        cells[2][4].init();
        cells[2][5].init();
        cells[2][6].init();
        cells[2][7].init(5);
        cells[2][8].init();

        cells[3][0].init();
        cells[3][1].init();
        cells[3][2].init(7);
        cells[3][3].init();
        cells[3][4].init(3);
        cells[3][5].init(1);
        cells[3][6].init();
        cells[3][7].init();
        cells[3][8].init();

        cells[4][0].init(1);
        cells[4][1].init();
        cells[4][2].init();
        cells[4][3].init(7);
        cells[4][4].init(4);
        cells[4][5].init(6);
        cells[4][6].init();
        cells[4][7].init();
        cells[4][8].init(2);

        cells[5][0].init();
        cells[5][1].init();
        cells[5][2].init();
        cells[5][3].init(5);
        cells[5][4].init(2);
        cells[5][5].init();
        cells[5][6].init(1);
        cells[5][7].init();
        cells[5][8].init();

        cells[6][0].init();
        cells[6][1].init(8);
        cells[6][2].init();
        cells[6][3].init();
        cells[6][4].init();
        cells[6][5].init();
        cells[6][6].init(6);
        cells[6][7].init();
        cells[6][8].init();

        cells[7][0].init(4);
        cells[7][1].init();
        cells[7][2].init(1);
        cells[7][3].init();
        cells[7][4].init(8);
        cells[7][5].init();
        cells[7][6].init(9);
        cells[7][7].init(3);
        cells[7][8].init();

        cells[8][0].init(7);
        cells[8][1].init(9);
        cells[8][2].init();
        cells[8][3].init();
        cells[8][4].init();
        cells[8][5].init();
        cells[8][6].init();
        cells[8][7].init();
        cells[8][8].init();

        grid.setGrid(cells);

        return grid;
    }
}
