package com.kdavidenko.interfaces;

public interface Page {
    void setHeader(Header header);

    void addRow(int idx, Row row);

    void addRow(Row row);

    Row getRow(int idx);

    String print();
}
