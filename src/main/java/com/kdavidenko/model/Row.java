package com.kdavidenko.model;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.*;


public class Row {
    private List<Cell> cells;
    private boolean closingRow;

    public Row() {
        cells = new ArrayList<Cell>(columnsNumber);
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public void addCell(int idx, Cell cell) {
        cells.add(idx, cell);
    }

    public String getCellData(int idx) {
        return cells.get(idx).getData();
    }

    public void setClosingRow(boolean closingRow) {
        this.closingRow = closingRow;
    }

    public boolean isClosingRow() {
        return closingRow;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(COLUMN_DELIMITER);
        for (Cell cell : cells) {
            sb.append(cell.print() + COLUMN_DELIMITER);
        }

        return sb.toString();
    }

    public static Row header(String[] columnsNames) {
        Row row = new Row();
        row.cells = new ArrayList<Cell>(columnsNumber);

        for (int i = 0; i < columnsNumber; i++)
            row.cells.add(new Cell(i, columnsNames[i]));

        return row;
    }

    public static String printLine() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pageWidth; i++)
            sb.append(ROWS_DELIMITER);

        return sb.toString();
    }
}
