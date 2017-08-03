package io.acode.sudoku_solver.model;

import io.acode.sudoku_solver.util.Locator;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Grid<Row<Cell/Column>>
public class Grid extends ArrayList<ArrayList<Cell>> {
    public Grid() {
        initCells();
    }

    private void initCells() {
        IntStream.range(0, 9).forEach(x -> {
            add(new ArrayList<>());
            IntStream.range(0, 9).forEach(y -> get(x).add(new Cell()));
        });
    }

    public Cell getCell(int x, int y) {
        return get(x).get(y);
    }

    Row getRow(int row) {
        return this.stream()
                .map(column -> column.get(row))
                .collect(Collectors.toCollection(Row::new));
    }

    Column getColumn(int x) {
        return get(x).stream().collect(Collectors.toCollection(Column::new));
    }

    Box getBox(int x, int y) {
        return this.stream()
                .filter(col -> Locator.locateBox(x) == Locator.locateBox(indexOf(col)))
                .flatMap(col ->
                        col.stream()
                                .filter(r -> Locator.locateBox(y) == Locator.locateBox(col.indexOf(r)))
                ).collect(Collectors.toCollection(Box::new));
    }

    /**
     * Removes the passed in value to be removed from the cells in Cell x/y's row, column, and box.
     * @param x - column number
     * @param y - row number
     * @param value - value to be removed
     */
    public void cleanCellSegments(int x, int y, int value) {
        getRow(y).clean(value);
        getColumn(x).clean(value);
        getBox(x, y).clean(value);
    }

    /**
     * Checks to see if the passed in value exists in Cell x/y's row, column, and box. If it does than Cell x/y is
     * set to that value.
     * @param x - column number
     * @param y - row number
     * @param value - value to be checked for
     */
    public void tryToSolve(int x, int y, int value) {
        if (getRow(y).valueIsUnique(value) || getColumn(x).valueIsUnique(value) || getBox(x, y).valueIsUnique(value)) {
            System.out.println("["+x+","+y+"]");
            System.out.println("before:\n " +this);
            getCell(x, y).init(value);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("\n\n\n------------------------------------\n");
        for (int row = 0; row < 9; row++) {
            output.append(getRow(row));
            output.append("\n------------------------------------\n");
        }
        return output.toString();
    }
}
