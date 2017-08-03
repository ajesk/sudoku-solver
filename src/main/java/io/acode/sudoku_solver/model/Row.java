package io.acode.sudoku_solver.model;

public class Row extends Segment {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.forEach(cell -> {
            builder.append("| ");
            builder.append(cell.getValue());
            builder.append(" ");
        });
        return builder.append("|").toString();
    }
}
