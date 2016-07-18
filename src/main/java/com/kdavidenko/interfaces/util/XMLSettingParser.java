package com.kdavidenko.interfaces.util;

public interface XMLSettingParser {
    /**
     * Парсит файл по пути <tt>fileName</tt>
     *
     * @param fileName файл с настройками
     * @throws Exception
     */
    void parse(String fileName) throws Exception;

    /**
     * Возвращает ширину документа из настроек.
     *
     * @return ширина документа
     */
    int getWidth();

    /**
     * Возвращает высоту документа из настроек.
     *
     * @return высота документа
     */
    int getHeight();

    /**
     * Возвращает наименования столбца в таблице
     * по индексу <tt>idx</tt>.
     *
     * @param idx индекс нужного столбца
     * @return наименования столбца в таблице
     * по индексу <tt>idx</tt>
     */
    String getColumnTitle(int idx);

    /**
     * Возвращает массив с наименованиями столбцов
     * в таблице.
     *
     * @return массив с наименованиями столбцов
     * в таблице
     */
    String[] getColumnsTitles();

    /**
     * Возвращает ширину столбца по индексу <tt>idx</tt>.
     *
     * @param idx индекс нужного столбца в таблице
     * @return ширину столбца по индексу <tt>idx</tt>
     */
    int getColumnWidth(int idx);

    /**
     * Возвращает количество стобцов в таблице.
     *
     * @return количество столбцов в таблице
     */
    int getNumberOfColumns();
}
