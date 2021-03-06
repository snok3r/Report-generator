package com.kdavidenko.implementations.model;

import com.kdavidenko.Setting;
import com.kdavidenko.interfaces.model.Page;
import com.kdavidenko.interfaces.model.Row;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.Setting.NEXT_LINE;

class PageImpl implements Page {

    private final List<Row> rows;
    private boolean ended;

    PageImpl() {
        rows = new ArrayList<Row>();
    }

    @Override
    public boolean isEnded() {
        return ended;
    }

    @Override
    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    @Override
    public void addRow(int idx, Row row) {
        rows.add(idx, row);
    }

    @Override
    public void addRow(Row row) {
        rows.add(row);
    }

    @Override
    public Row getRow(int idx) {
        return rows.get(idx);
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        for (Row row : rows) {
            sb.append(row.print()).append(NEXT_LINE);
            if (row.hasRowDelimiter())
                sb.append(row.printLine()).append(NEXT_LINE);
        }
        if (ended)
            sb.append(Setting.PAGE_DELIMITER);

        return sb.toString();
    }
}
