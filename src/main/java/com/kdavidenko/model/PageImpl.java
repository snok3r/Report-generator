package com.kdavidenko.model;

import com.kdavidenko.interfaces.Page;
import com.kdavidenko.interfaces.Row;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.NEXT_LINE;

class PageImpl implements Page {

    private final List<Row> rows;

    PageImpl() {
        rows = new ArrayList<Row>();
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
            if (row.isClosingRow())
                sb.append(row.printLine()).append(NEXT_LINE);
        }

        return sb.toString();
    }
}
