package io.acode.sudoku_solver;

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

    Grid grid = new Grid();


    public static void main(String... args) {
        log.info("starting application");
        SudokuSolver sudokuSolver = new SudokuSolver();
    }


}
