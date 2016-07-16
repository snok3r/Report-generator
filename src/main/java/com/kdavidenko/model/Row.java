package com.kdavidenko.model;

import java.util.LinkedList;
import java.util.List;

import static com.kdavidenko.util.Settings.*;


public class Row {
    private List<Cell> cells;

    public Row() {
        cells = new LinkedList<>();

        cells.add(new Cell(0, "cell"));
        cells.add(new Cell(1, "cell"));
        cells.add(new Cell(2, "cell"));
    }

    public static Row header() {
        Row row = new Row();
        row.cells = new LinkedList<>();

        row.cells.add(new Cell(0, "Номер"));
        row.cells.add(new Cell(1, "Дата"));
        row.cells.add(new Cell(2, "ФИО"));

        return row;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(columnDelimeter);
        for (Cell cell : cells) {
            sb.append(cell.print() + columnDelimeter);
        }
        sb.append(endOfLine);

        for (int i = 0; i < pageWidth; i++)
            sb.append(rowsDelimeter);

        return sb.toString();
    }
}
