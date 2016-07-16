package com.kdavidenko.interfaces;

public interface Page {
    void setHeader(Row header);

    void addRow(int idx, Row row);

    void addRow(Row row);

    Row getRow(int idx);

    String print();
}
