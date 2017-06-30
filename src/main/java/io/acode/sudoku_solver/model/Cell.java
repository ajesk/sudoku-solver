package io.acode.sudoku_solver.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A specific square in the Sudoku Grid
 */
@Data
public class Cell {
    private List<Integer> values;
    private boolean solved = false;

    Cell() {
        init();
    }
    // Init with no value
    public void init() {
        setValues(new PossibleValues().get());
    }

    // Init with solved value
    public void init(int value) {
        values = new ArrayList<>();
        values.add(value);
        setSolved(true);
    }

    void removeValue(Integer value) {
        if (values.contains(value)) {
            values.remove(values.indexOf(value));
            if (values.size() == 1) {
                setSolved(true);
            } else if (values.size() == 0) {
                System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
            }
        }
    }

    // Just an unsolved cell provider
    private class PossibleValues {
        List<Integer> get() {
            return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
    }

}
