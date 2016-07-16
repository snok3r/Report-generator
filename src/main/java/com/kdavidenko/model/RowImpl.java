package com.kdavidenko.model;

import com.kdavidenko.interfaces.Cell;
import com.kdavidenko.interfaces.Row;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.*;


public class RowImpl implements Row {

    private List<Cell> cells;
    private boolean closingRow;

    public RowImpl() {
        cells = new ArrayList<Cell>(columnsNumber);
    }

    @Override
    public void addCell(Cell cell) {
        cells.add(cell);
    }

    @Override
    public void addCell(int idx, Cell cell) {
        cells.add(idx, cell);
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
    public void setClosingRow(boolean closingRow) {
        this.closingRow = closingRow;
    }

    @Override
    public boolean isClosingRow() {
        return closingRow;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(COLUMN_DELIMITER);
        for (Cell cell : cells) {
            sb.append(cell.print() + COLUMN_DELIMITER);
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
