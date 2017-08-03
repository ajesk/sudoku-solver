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

    public Row getRow(int row) {
        return (Row) this.stream()
                .map(column -> column.get(row))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Column getColumn(int x) {
        return (Column) get(x);
    }

    public Box getBox(int x, int y) {
        return (Box) this.stream()
                .filter(col -> Locator.locateBox(x) == Locator.locateBox(indexOf(col)))
                .flatMap(col ->
                        col.stream()
                                .filter(r -> Locator.locateBox(y) == Locator.locateBox(col.indexOf(r)))
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    public void cleanCellSegments(int x, int y, int value) {
        getRow(y).clean(value);
        getColumn(x).clean(value);
        getBox(x, y).clean(value);
    }

    public boolean valueIsUnique(int x, int y, int value) {
        return getRow(y).valueIsUnique(value) || getColumn(x).valueIsUnique(value) || getBox(x, y).valueIsUnique(value);
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
