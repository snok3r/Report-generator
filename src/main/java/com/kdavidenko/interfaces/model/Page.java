package com.kdavidenko.interfaces.model;

public interface Page {

    boolean isEnded();

    void setEnded(boolean ended);

    void addRow(int idx, Row row);

    void addRow(Row row);

    Row getRow(int idx);

    String print();
}
