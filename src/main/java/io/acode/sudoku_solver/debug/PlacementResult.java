package io.acode.sudoku_solver.debug;

import lombok.Data;

@Data
public class PlacementResult {
    int number;
    boolean placed;

    PlacementResult() {
        this(false);
    }

    PlacementResult(boolean result) {
        setPlaced(result);
    }

    PlacementResult(int number) {
        this(number, true);
    }

    PlacementResult(int number, boolean result) {
        this(result);
        setNumber(number);
    }
}
