package io.acode.sudoku_solver.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * A specific square in the Sudoku Grid
 */
@Data
public class Cell {
    private List<Integer> values;
    private boolean solved;

    // Init with no value
    public void init() {
        setValues(PossibleValues.get());
        setSolved(false);
    }

    // Init with solved value
    public void init(int value) {
        values = new ArrayList<>();
        values.add(value);
        setSolved(true);
    }

    public void removeValue(Integer value) {
        values.remove(values.indexOf(value));
    }
}
