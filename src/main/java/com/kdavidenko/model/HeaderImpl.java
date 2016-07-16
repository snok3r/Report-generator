package com.kdavidenko.model;

public class HeaderImpl implements com.kdavidenko.interfaces.Header {

    private String[] columnNames;

    @Override
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    @Override
    public String[] getColumnNames() {
        return columnNames;
    }

    @Override
    public String print() {
        return "";
    }
}
