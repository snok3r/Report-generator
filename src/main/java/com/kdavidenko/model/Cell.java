package com.kdavidenko.model;

import static com.kdavidenko.util.Setting.getColumnWidth;

public class Cell {

    private final int idx;
    private String data;

    public Cell(int idx) {
        this(idx, "");
    }

    public Cell(int idx, String data) {
        this.idx = idx;
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(data).append(" ");

        int spacesRemain = getColumnWidth(idx) - data.length();
        for (int i = 0; i < spacesRemain; i++)
            sb.append(" ");

        return sb.toString();
    }
}
