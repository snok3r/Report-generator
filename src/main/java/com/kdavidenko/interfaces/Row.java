package com.kdavidenko.interfaces;

public interface Row {
    void addCell(Cell cell);

    void addCell(int idx, Cell cell);

    String getCellData(int idx);

    Cell getCell(int idx);

    void setClosingRow(boolean closingRow);

    boolean isClosingRow();

    String print();

    String printLine();
}
