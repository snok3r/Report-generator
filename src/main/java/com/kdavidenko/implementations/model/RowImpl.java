package com.kdavidenko.implementations.model;

import com.kdavidenko.interfaces.model.Cell;
import com.kdavidenko.interfaces.model.DocumentElementsFactory;
import com.kdavidenko.interfaces.model.Row;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.Setting.*;


class RowImpl implements Row {

    private final List<Cell> cells;
    private boolean closingRow;

    RowImpl() {
        cells = new ArrayList<Cell>(columnsNumber);

        DocumentElementsFactory factory = DocumentElementsImpl.getFactory();
        for (int i = 0; i < columnsNumber; i++)
            cells.add(factory.getCell(i));
    }

    @Override
    public void addCell(Cell cell) {
        cells.add(cell);
    }

    @Override
    public void addCell(int idx, Cell cell) {
        cells.set(idx, cell);
    }

    @Override
    public String getCellData(int idx) {
        return cells.get(idx).getData();
    }

    @Override
    public Cell getCell(int idx) {
        return cells.get(idx);
    }

    @Override
    public void setRowDelimiter(boolean hasRowDelimiter) {
        this.closingRow = hasRowDelimiter;
    }

    @Override
    public boolean hasRowDelimiter() {
        return closingRow;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(COLUMN_DELIMITER);
        for (Cell cell : cells) {
            sb.append(cell.print()).append(COLUMN_DELIMITER);
        }

        return sb.toString();
    }

    @Override
    public String printLine() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pageWidth; i++)
            sb.append(ROWS_DELIMITER);

        return sb.toString();
    }
}
