package io.acode.sudoku_solver;

import io.acode.sudoku_solver.debug.DemoGridLoader;
import io.acode.sudoku_solver.model.Grid;
import lombok.extern.slf4j.Slf4j;

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

    private void run() {
        do {
            IntStream.range(0, 8).forEach(x -> IntStream.range(0, 8).forEach(y -> {
                    if (grid.getCell(x, y).isSolved()) {
                        int val = grid.getCell(x, y).getValues().get(0);
                        grid.cleanRow(y, val);
                        grid.cleanColumn(x, val);
                        grid.cleanBox(x, y, val);
                    }
                })
            );
            System.out.println(grid.toString());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        } while (true);

    }

    public static void main(String... args) {
        log.info("starting application");
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.run();
    }


}
