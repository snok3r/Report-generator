package com.kdavidenko.model;

import com.kdavidenko.interfaces.Cell;

import static com.kdavidenko.util.Setting.getColumnWidth;

public class CellImpl implements Cell {

    private final int idx;
    private String data;

    public CellImpl(int idx) {
        this(idx, "");
    }

    public CellImpl(int idx, String data) {
        this.idx = idx;
        this.data = data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(data).append(" ");

        int spacesRemain = getColumnWidth(idx) - data.length();
        for (int i = 0; i < spacesRemain; i++)
            sb.append(" ");

        return sb.toString();
    }
}
