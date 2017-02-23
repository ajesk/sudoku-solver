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
public class SudokuSolver {
    private static final List<Integer> POSSIBLE_VALUES = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    private List<Integer>[][] grid;

    /**
     * Figures out if the target box is solved
     * @param x coordinate
     * @param y coordinate
     * @return if the box is solved
     */
    private boolean isSolved(int x, int y) {
        return getBoxValue(x, y).size() > 1;
    }

    /**
     * Gets the remaining possible values from the target box
     * @param x coordinate
     * @param y coordinate
     * @return remaining possible numbers
     */
    private List<Integer> getBoxValue(int x, int y) {
        return grid[x][y];
    }

    private void writeBoxValue(int x, int y, List<Integer> value) {
        grid[x][y] = value;
    }

    private void removePossibleNumberFromBox(int x, int y, int number) {
        grid[x][y].remove(grid[x][y].indexOf(number));
    }

    public static void main(String... args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
    }


}
