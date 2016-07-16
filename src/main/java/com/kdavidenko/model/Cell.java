package com.kdavidenko.model;

import static com.kdavidenko.util.Settings.getColumnSize;

public class Cell {

    private String data;
    private int idx;

    public Cell(int idx, String data) {
        this.idx = idx;
        this.data = data;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(data).append(" ");

        int spacesRemain = getColumnSize(idx) - data.length();
        for (int i = 0; i < spacesRemain; i++)
            sb.append(" ");

        return sb.toString();
    }
}
