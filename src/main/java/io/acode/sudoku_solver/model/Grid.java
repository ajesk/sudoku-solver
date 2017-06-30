package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.util.Locator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Grid<Row<Cell/Column>>
public class Grid extends ArrayList<ArrayList<Cell>> {
    public Grid() {
        initCells();
    }

    private void initCells() {
        for (int x = 0; x < 9; x++) {
            add(new ArrayList<>());
            for (int y = 0; y < 9; y++) {
                get(x).add(new Cell());
            }
        }
    }

    public Cell getCell(int column, int row) {
        return get(column).get(row);
    }

    ArrayList<Cell> getRow(int row) {
        return this.stream()
                .map(column -> column.get(row))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    ArrayList<Cell> getColumn(int column) {
        return get(column);

    }

    ArrayList<Cell> getBox(int column, int row) {
        return null;
    }

    public void cleanRow(int row, int value) {
        getRow(row).stream()
            .filter(cell -> !cell.isSolved())
            .forEach(cell -> cell.removeValue(value));
    }

    public void cleanColumn(int column, int value) {
        getColumn(column).stream()
            .filter(x -> !x.isSolved())
            .forEach(cell -> cell.removeValue(value));
    }

    public void cleanBox(int x, int y, int value) {
        this.stream()
            .filter(row -> Locator.locateBox(this.indexOf(row)) == Locator.locateBox(y))
            .forEach(row -> row.stream()
                .filter(cell -> Locator.locateBox(row.indexOf(cell)) == Locator.locateBox(x))
                .filter(cell -> !cell.isSolved())
                .forEach(cell -> cell.removeValue(value))
            );
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("\n------------------------------------\n");
        for (int column = 0; column < 9; column++) {
            output.append("|");
            for (int row = 0; row < 9; row++) {
                Cell cell = getCell(row, column);
                if (cell.isSolved()) {
                    output.append(" " + cell.getValues().get(0).toString() + " ");
                }
                else output.append(" 0 ");
                output.append("|");
            }
            output.append("\n------------------------------------\n");
        }
        return output.toString();
    }
}
