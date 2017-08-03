package io.acode.sudoku_solver.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A specific square in the Sudoku Grid
 */
@Data
public class Cell {
    private List<Integer> values;
    private boolean solved = false;
    byte[] id = new byte[5];

    Cell() {
        init();
    }
    // Init with no value
    void init() {
        setValues(new PossibleValues().get());
        new Random().nextBytes(id);
        setSolved(false);
    }

    // Init with solved value
    public void init(int value) {
        values = new ArrayList<>();
        values.add(value);
        setSolved(true);
    }

    void removeValue(Integer value) {
        if (values.contains(value) && !solved) {
            values.remove(values.indexOf(value));
            if (values.size() == 1) {
                setSolved(true);
            }
        }
    }

    public int getValue() {
        return isSolved() ? values.get(0) : 0;
    }

    // Just an unsolved cell provider
    private class PossibleValues {
        List<Integer> get() {
            return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
    }

}
