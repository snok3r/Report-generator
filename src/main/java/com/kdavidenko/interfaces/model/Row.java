package com.kdavidenko.interfaces.model;

public interface Row {
    /**
     * Добавляет ячейку <tt>cell</tt>
     * на следующее в строке место.
     *
     * @param cell ячейка для добавления
     */
    void addCell(Cell cell);

    /**
     * Добавляет ячейку <tt>cell</tt> в данную строку на
     * место <tt>idx</tt>.
     *
     * @param idx  индекс ячейки
     * @param cell ячейка для добавления
     */
    void addCell(int idx, Cell cell);

    /**
     * Возвращает значение ячейки по индексу <tt>idx</tt>.
     *
     * @param idx индекс желаемой ячейки
     * @return значение ячейки по индексу <tt>idx</tt>
     */
    String getCellData(int idx);

    /**
     * Возвращает ячейку по индексу <tt>idx</tt>.
     *
     * @param idx индекс желаемой ячейки
     * @return ячейка по индексу <tt>idx</tt>
     */
    Cell getCell(int idx);

    /**
     * @param closingRow параметр, определяющий заврешенность
     *                   данных в строке
     */
    void setClosingRow(boolean closingRow);

    /**
     * @return true, если данная строка
     * представляет законченные данные
     */
    boolean isClosingRow();

    /**
     * Возвращает строку, представляющую строку.
     *
     * @return строка, представляющая строку
     */
    String print();

    /**
     * Возвращает строку, представляющую разделитель между
     * строками.
     *
     * @return строка, представляющая разделитель между строками
     */
    String printLine();
}
