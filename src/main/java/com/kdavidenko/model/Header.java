package com.kdavidenko.model;

import static com.kdavidenko.util.Setting.columnsNumber;

public class Header extends RowImpl {

    public Header(String[] columnsNames) {
        for (int i = 0; i < columnsNumber; i++)
            addCell(new CellImpl(i, columnsNames[i]));
    }
}
