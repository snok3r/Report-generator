package com.kdavidenko.model;

import com.kdavidenko.interfaces.Header;

import static com.kdavidenko.util.Setting.columnsNumber;

class HeaderTemp extends RowImpl implements Header {

    HeaderTemp(String[] columnsNames) {
        for (int i = 0; i < columnsNumber; i++)
            addCell(new CellImpl(i, columnsNames[i]));
    }

    private String[] columnNames;

    @Override
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    @Override
    public String[] getColumnNames() {
        return columnNames;
    }
}
