package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.util.Locator;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        return this.stream()
            .filter(col -> Locator.locateBox(column) == Locator.locateBox(indexOf(col)))
            .flatMap(col ->
                col.stream()
                    .filter(r -> Locator.locateBox(row) == Locator.locateBox(col.indexOf(r)))
            ).collect(Collectors.toCollection(ArrayList::new));
    }

    public void cleanRow(int row, int value) {
        getRow(row).forEach(cell -> cell.removeValue(value));
    }

    public void cleanColumn(int column, int value) {
        getColumn(column).forEach(cell -> cell.removeValue(value));
    }

    public void cleanBox(int x, int y, int value) {
        getBox(x, y).forEach(cell -> cell.removeValue(value));
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("\n\n\n------------------------------------\n");
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
