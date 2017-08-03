package io.acode.sudoku_solver.model;

public class Column extends Segment {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.forEach(cell -> {
            builder.append("| ");
            builder.append(cell.getValue());
            builder.append(" |\n");
        });
        return builder.toString();
    }
}
