package io.acode.sudoku_solver.util;

/**
 * Created by aaron on 4/15/17.
 */
public class Locator {
    public static int locateBox(int cellIndex) {
        return (cellIndex / 3) * 3;
    }
}
