package com.kdavidenko.implementations.model;

import com.kdavidenko.interfaces.model.*;

public class DocumentElementsImpl implements DocumentElementsFactory {
    private static final DocumentElementsFactory ourFactory = new DocumentElementsImpl();

    public static DocumentElementsFactory getFactory() {
        return ourFactory;
    }

    private DocumentElementsImpl() {
    }

    @Override
    public Document getDocument() {
        return new DocumentImpl();
    }

    @Override
    public Page getPage() {
        return new PageImpl();
    }

    @Override
    public Row getRow() {
        return new RowImpl();
    }

    @Override
    public Cell getCell(int columnIndex) {
        return new CellImpl(columnIndex);
    }

    @Override
    public Cell getCell(int columnIndex, String data) {
        return new CellImpl(columnIndex, data);
    }
}
