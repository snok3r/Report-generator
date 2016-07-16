package com.kdavidenko.model;

import com.kdavidenko.interfaces.Header;
import com.kdavidenko.interfaces.Page;
import com.kdavidenko.interfaces.Row;

import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.NEXT_LINE;

class PageImpl implements Page {

    private final List<Row> rows;
    private Header header;

    PageImpl() {
        rows = new ArrayList<Row>();
    }

    @Override
    public void setHeader(Header header) {
        this.header = header;
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

//        for (Row headRow : header) {
//            sb.append(headRow.print() + NEXT_LINE);
//            if (headRow.isClosingRow())
//                sb.append(headRow.printLine() + NEXT_LINE);
//        }

        if (header != null) {
            sb.append(header.print()).append(NEXT_LINE);
            sb.append(header.printLine()).append(NEXT_LINE);
        }

        for (Row row : rows) {
            sb.append(row.print()).append(NEXT_LINE);
            if (row.isClosingRow())
                sb.append(row.printLine()).append(NEXT_LINE);
        }

        return sb.toString();
    }
}
