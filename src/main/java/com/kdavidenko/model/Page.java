package com.kdavidenko.model;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.NEXT_LINE;

public class Page {

    private final List<Row> rows;
    private static Row header;

    public Page() {
        rows = new ArrayList<Row>();
    }

    public static void setHeader(Row header) {
        Page.header = header;
    }

    public void addRow(int idx, Row row) {
        rows.add(idx, row);
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public Row getRow(int idx) {
        return rows.get(idx);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(header.print() + NEXT_LINE);
        sb.append(Row.printLine() + NEXT_LINE);

        for (Row row : rows) {
            sb.append(row.print() + NEXT_LINE);
            if (row.isClosingRow())
                sb.append(Row.printLine() + NEXT_LINE);
        }

        return sb.toString();
    }
}
