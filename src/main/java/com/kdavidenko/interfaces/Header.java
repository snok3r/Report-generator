package com.kdavidenko.interfaces;

public interface Header {

    void setColumnNames(String[] columnNames);

    String[] getColumnNames();

    String print();
}
