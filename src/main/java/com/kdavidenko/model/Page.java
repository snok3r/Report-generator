package com.kdavidenko.model;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Settings.endOfLine;

public class Page {

    private List<Row> rows;
    private Row header;

    public Page() {
        rows = new ArrayList<>();
        rows.add(new Row());
        rows.add(new Row());

        header = Row.header();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        sb.append(header.print() + endOfLine);
        for (Row row : rows)
            sb.append(row.print() + endOfLine);

        return sb.toString();
    }
}
