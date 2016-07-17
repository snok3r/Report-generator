package com.kdavidenko.interfaces.model;

public interface Cell {

    /**
     * Возвращает индекс столбца для данной ячейки.
     *
     * @return индекс столбца для данной ячейки
     */
    int getCellIndex();

    /**
     * Устанавливает значение ячейки равным <tt>data</tt>.
     *
     * @param data желаемое значение ячейки
     * @return возвращает эту ячейку с новым значением
     */
    Cell setData(String data);

    /**
     * Возвращает значение ячейки.
     *
     * @return значение ячейки
     */
    String getData();

    /**
     * @return true если ячейка пустая (значение = "")
     */
    boolean isEmpty();

    /**
     * Возвращает строку, представляющую ячейку.
     *
     * @return строка, представляющая ячейку
     */
    String print();
}
