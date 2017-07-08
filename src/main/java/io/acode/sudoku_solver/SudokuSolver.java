package io.acode.sudoku_solver;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import io.acode.sudoku_solver.model.Cell;
import io.acode.sudoku_solver.model.Grid;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
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

    /**
     * Loops through the 81 cells included withing the sudoku grid and calls the 2 methods for removing possible values
     * and solving cells.
     *
     * IMPORTANT!!! Do not confuse this with the movie of the same title. They have almost nothing in common. I would
     * recommend that you go see if though.
     */
    private void looper() {
        IntStream.range(0, 8).forEach(x -> IntStream.range(0, 8).forEach(y -> {
            Cell cell = grid.getCell(x, y);
            if (cell.isSolved()) cleanGrid(x, y, cell.getValues().get(0));
            else isolateValues(x, y, cell.getValues());
        }));
    }

    /**
     * This method takes the x and y coordinates of a solved cell and removes all of the instances of that number from
     * its row, column, and box from the unsolved boxes possible values
     * @param x coord
     * @param y coord
     */
    private void cleanGrid(int x, int y, int value) {
        grid.cleanRow(y, value);
        grid.cleanColumn(x, value);
        grid.cleanBox(x, y, value);
    }

    /**
     * Takes the x and y coordinates of an unsolved cell and validates if it contains a values that is not a possible/
     * actual value in any any other related boxes.
     * @param x coord
     * @param y coord
     */
    private void isolateValues(int x, int y, List<Integer> value) {

    }

    private void run() {
        do {
            looper();
            System.out.println(grid.toString());
            try {
                Thread.sleep(1000);
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
