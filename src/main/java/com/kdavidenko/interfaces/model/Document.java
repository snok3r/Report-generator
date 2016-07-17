package com.kdavidenko.interfaces.model;

import java.util.List;

public interface Document {
    /**
     * Добавляет страницу <tt>page</tt> к документу.
     *
     * @param page страница для добавления
     */
    void addPage(Page page);

    /**
     * Возвращает лист со страницами данного документа.
     *
     * @return лист со страницами данного документа
     */
    List<Page> getPages();
}
