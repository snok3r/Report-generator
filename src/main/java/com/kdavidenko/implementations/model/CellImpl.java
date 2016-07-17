package com.kdavidenko.implementations.model;

import com.kdavidenko.interfaces.model.Cell;

import static com.kdavidenko.Setting.getColumnWidth;

class CellImpl implements Cell {

    private final int idx;
    private String data;

    CellImpl(int idx) {
        this(idx, "");
    }

    CellImpl(int idx, String data) {
        this.idx = idx;
        this.data = data;
    }

    @Override
    public int getCellIndex() {
        return idx;
    }

    @Override
    public Cell setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public boolean isEmpty() {
        return "".equals(data);
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

    @Override
    public String toString() {
        return "CellImpl{" +
                "idx=" + idx +
                ", data='" + data + '\'' +
                '}';
    }
}
