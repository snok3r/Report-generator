package com.kdavidenko.interfaces.model;

import com.kdavidenko.interfaces.model.Cell;
import com.kdavidenko.interfaces.model.Document;
import com.kdavidenko.interfaces.model.Page;
import com.kdavidenko.interfaces.model.Row;

public interface DocumentElementsFactory {

    /**
     * Возвращает пустой документ,
     * в который можно добавлять страницы.
     *
     * @return пустой документ
     */
    Document getDocument();

    /**
     * Возвращает пустую страницу,
     * в которую можно добавлять строки.
     *
     * @return пустая страница
     */
    Page getPage();

    /**
     * Возвращает строку с пустыми ячейкам.
     *
     * @return строка с пустыми ячейками
     */
    Row getRow();

    /**
     * Возвращает пустую ячейку (значение = "").
     *
     * @param columnIndex индекс столбца
     * @return пустая ячейка (значение = "")
     */
    Cell getCell(int columnIndex);

    /**
     * Возвращает ячейку с данными <tt>data</tt>.
     *
     * @param columnIndex индекс столбца
     * @param data        значение ячейки
     * @return ячейка с данными <tt>data</tt>
     */
    Cell getCell(int columnIndex, String data);
}
