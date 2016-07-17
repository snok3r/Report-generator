package com.kdavidenko;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    public static final String NEXT_LINE = System.getProperty("line.separator");
    public static final char COLUMN_DELIMITER = '|';
    public static final char ROWS_DELIMITER = '-';
    public static final char PAGE_DELIMITER = '~';
    public static final char DATA_DELIMITER = '\t';

    public static int pageWidth;
    public static int pageHeight;
    public static int columnsNumber;
    private static List<Integer> columnsWidths;

    /**
     * Устанавливает ширину документа (в символах)
     *
     * @param pageWidth ширина документа (в символах)
     */
    public static void setPageWidth(int pageWidth) {
        Setting.pageWidth = pageWidth;
    }

    /**
     * Устанавливает высоту документа
     *
     * @param pageHeight высота документа (в символах)
     */
    public static void setPageHeight(int pageHeight) {
        Setting.pageHeight = pageHeight;
    }

    /**
     * Устанавливает количество столбцов.
     *
     * @param columnsNumber количество столбцов
     */
    public static void setColumnsNumber(int columnsNumber) {
        Setting.columnsNumber = columnsNumber;
        columnsWidths = new ArrayList<Integer>(columnsNumber);
    }

    /**
     * Устанавливает ширину колонки по индексу <tt>idx</tt>
     * размером <tt>size</tt>.
     *
     * @param idx  индекс нужной колонки
     * @param size ширина колонки (в символах)
     */
    public static void setColumnWidth(int idx, int size) {
        columnsWidths.add(idx, size);
    }

    /**
     * Возвращает ширину колонки по индексу <tt>idx</tt>.
     *
     * @param idx индекс нужной колонки
     * @return ширина колонки по индексу <tt>idx</tt>
     */
    public static int getColumnWidth(int idx) {
        return columnsWidths.get(idx);
    }

    /**
     * Проверяет валидность файла настроек.
     * Например, суммирует данную ширину каждой колонки и проверяет
     * с шириной документа. Также, высота и ширина документа должны быть
     * не меньше 3.
     *
     * @return true если настройки правильные
     */
    public static boolean isSettingValid() {
        int cumulativePageWidth = 0;
        for (Integer width : columnsWidths)
            cumulativePageWidth += width + 2;
        cumulativePageWidth += columnsWidths.size() + 1;

        return pageWidth >= 3 && pageHeight >= 3 && pageWidth == cumulativePageWidth;
    }
}
