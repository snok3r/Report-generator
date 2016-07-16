package com.kdavidenko.interfaces;

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
     * Returns an empty Row.
     * You can add Cells in it.
     *
     * @return an empty Row
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
