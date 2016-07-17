package com.kdavidenko.interfaces.model;

import com.kdavidenko.interfaces.model.Cell;
import com.kdavidenko.interfaces.model.Document;
import com.kdavidenko.interfaces.model.Page;
import com.kdavidenko.interfaces.model.Row;

public interface DocumentElementsFactory {

    /**
     * Return an empty Document.
     * You can add Pages in it.
     *
     * @return an empty Document
     */
    Document getDocument();

    /**
     * Returns an empty Page.
     * You can add Rows on it.
     *
     * @return an empty Page
     */
    Page getPage();

    /**
     * Returns an Row with empty-data Cells.
     *
     * @return an Row with empty-data Cells
     */
    Row getRow();

    /**
     * Returns Cell with empty data ("").
     *
     * @param columnIndex index of the column where to put it
     * @return Cell with empty data ("")
     */
    Cell getCell(int columnIndex);

    /**
     * Returns Cell with given <tt>data</tt>
     *
     * @param columnIndex index of the column where to put it
     * @param data        value to put in
     * @return Cell with given <tt>data</tt>
     */
    Cell getCell(int columnIndex, String data);
}