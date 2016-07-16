package com.kdavidenko.util;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    public static final String endOfLine = System.getProperty("line.separator");
    public static final char columnDelimiter = '|';
    public static final char rowsDelimiter = '-';
    public static final char pageDelimiter = '~';
    public static final char dataDelimiter = '\t';

    public static int pageWidth;
    public static int pageHeight;
    public static int columnsNumber;
    private static List<Integer> columnsWidth;

    public static void setPageWidth(int pageWidth) {
        Setting.pageWidth = pageWidth;
    }

    public static void setPageHeight(int pageHeight) {
        Setting.pageHeight = pageHeight;
    }

    public static void setColumnsNumber(int columnsNumber) {
        Setting.columnsNumber = columnsNumber;
        columnsWidth = new ArrayList<Integer>(columnsNumber);
    }

    public static void setColumnWidth(int idx, int size) {
        columnsWidth.add(idx, size);
    }

    public static int getColumnWidth(int idx) {
        return columnsWidth.get(idx);
    }

    public static boolean isSettingValid() {
        int cumulativePageWidth = 0;
        for (Integer width : columnsWidth)
            cumulativePageWidth += width + 2;
        cumulativePageWidth += columnsWidth.size() + 1;

        return pageWidth == cumulativePageWidth;
    }
}
