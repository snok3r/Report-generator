package com.kdavidenko.interfaces;

public interface DocumentElementsFactory {

    Document getDocument();

    Page getPage();

    Header getHeader(String[] columnNames);

    Row getRow();

    Cell getCell(int columnIndex);
}
