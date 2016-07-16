package com.kdavidenko.model;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.endOfLine;
import static com.kdavidenko.util.Setting.pageDelimeter;

public class Page {

    private List<Row> rows;
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

        sb.append(header.print() + endOfLine);
        sb.append(Row.printLine() + endOfLine);

        for (Row row : rows) {
            sb.append(row.print() + endOfLine);
            if (row.isClosingRow())
                sb.append(Row.printLine() + endOfLine);
        }

        return sb.toString();
    }

    public static String printPageDelimeter() {
        return String.valueOf(pageDelimeter);
    }
}
