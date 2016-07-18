package com.kdavidenko.interfaces.model;

public interface Page {

    /**
     * Добавляет строку <tt>row</tt> на страницу
     * на место <tt>idx</tt>.
     *
     * @param idx место на странице
     * @param row строка для добавления
     */
    void addRow(int idx, Row row);

    /**
     * Добавляет строку <tt>row</tt> на
     * следующее на странице место.
     *
     * @param row строка для добавления
     */
    void addRow(Row row);

    /**
     * Возвращает ячейку по индексу <tt>idx</tt>.
     *
     * @param idx индекс (место) ячейка на странице
     * @return ячейка по индексу <tt>idx</tt>
     */
    Row getRow(int idx);

    /**
     * @return true, если страница полностью заполнена
     */
    boolean isEnded();

    /**
     * Устанавливает состояние заполнености страницы.
     *
     * @param ended true, показывает, что страница заполнена.
     */
    void setEnded(boolean ended);

    /**
     * Возвращает строку, представляющую страницу.
     *
     * @return строка, представляющая страницу
     */
    String print();
}
