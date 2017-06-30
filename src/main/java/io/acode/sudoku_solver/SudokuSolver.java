package io.acode.sudoku_solver;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import io.acode.sudoku_solver.model.Grid;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 02/23/2017
 * A small application which applies a purely logical solution to Sudoku puzzles. There are some limitations to this
 * application as it will only solve puzzles ranging from easy to moderate difficulty. Puzzles beyond that require some
 * form of guessing and would require a more blunt method of solving for numbers after a certain point. It is a possibility
 * that I revisit this code eventually to include this ham-fisted method of solving this problem.
 */
@Slf4j
public class SudokuSolver {

    private Grid grid = DemoGridLoader.getDemoGrid();



    private void run() {
        Grid lastIteration;

        do {
            lastIteration = grid;
            grid.forEach(row -> {
                int y = grid.indexOf(row);
                row.forEach(cell -> {
                    int x = row.indexOf(cell);
                    if (cell.isSolved()) {
                        int val = cell.getValues().get(0);
                        grid.cleanBox(x, y, val);
                        grid.cleanRow(y, val);
                        grid.cleanColumn(x, val);
                    }
                });
            });
            System.out.println(grid.toString());
        } while (true);

    }

    public static void main(String... args) {
        log.info("starting application");
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.run();
    }


}
