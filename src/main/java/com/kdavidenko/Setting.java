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

    public static void setPageWidth(int pageWidth) {
        Setting.pageWidth = pageWidth;
    }

    public static void setPageHeight(int pageHeight) {
        Setting.pageHeight = pageHeight;
    }

    public static void setColumnsNumber(int columnsNumber) {
        Setting.columnsNumber = columnsNumber;
        columnsWidths = new ArrayList<Integer>(columnsNumber);
    }

    public static void setColumnWidth(int idx, int size) {
        columnsWidths.add(idx, size);
    }

    public static int getColumnWidth(int idx) {
        return columnsWidths.get(idx);
    }

    public static boolean isSettingValid() {
        int cumulativePageWidth = 0;
        for (Integer width : columnsWidths)
            cumulativePageWidth += width + 2;
        cumulativePageWidth += columnsWidths.size() + 1;

        return pageWidth >= 3 && pageHeight >= 3 && pageWidth == cumulativePageWidth;
    }
}
