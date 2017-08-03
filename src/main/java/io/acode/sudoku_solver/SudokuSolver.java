package io.acode.sudoku_solver;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import io.acode.sudoku_solver.model.Cell;
import io.acode.sudoku_solver.model.Grid;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
    private int changedValues = 0;

    /**
     * Loops through the 81 cells included withing the sudoku grid and calls the 2 methods for removing possible values
     * and solving cells. If the cell is solved it removes all of the values in the related unsolved cells. If the cell
     * is unsolved it then checks all of its values to see if it contains a unique value. If it has a unique value
     * it then sets is value to that.
     *
     * IMPORTANT!!! Do not confuse this with the movie of the same title. They have almost nothing in common. I would
     * recommend that you go see if though.
     */
    private void looper() {
        IntStream.range(0, 9).forEach(x -> IntStream.range(0, 9).forEach(y -> {
            Cell cell = grid.getCell(x, y);
            if (cell.isSolved()) grid.cleanCellSegments(x, y, cell.getValue());
            else cell.getValues().forEach(val -> {
                if (!cell.isSolved()) grid.tryToSolve(x, y, val);
            });
        }));
    }

    private void run() {
        do {
            looper();
            System.out.println(grid.toString());
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                //todo bad news bears
            }
        } while (true);

    }

    public static void main(String... args) {
        log.info("starting application");
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.run();
    }


}
