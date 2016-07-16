package com.kdavidenko.model;

import com.kdavidenko.interfaces.*;

public class DocumentElementsImpl implements DocumentElementsFactory {
    @Override
    public Document getDocument() {
        return new DocumentImpl();
    }

    @Override
    public Page getPage() {
        return new PageImpl();
    }

    @Override
    public Header getHeader(String[] columnNames) {
        return new HeaderTemp(columnNames);
    }

    @Override
    public Row getRow() {
        return new RowImpl();
    }

    @Override
    public Cell getCell(int columnIndex) {
        return new CellImpl(columnIndex);
    }
}
