package com.kdavidenko.util;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    public static final char endOfLine = '\n';
    public static final char columnDelimeter = '|';
    public static final char rowsDelimeter = '-';
    public static final char pageDelimeter = '~';

    public static char dataDelimeter;

    public static int pageWidth;
    public static int pageHeight;
    public static int columnsNumber;
    private static List<Integer> columnsWidth;

    public static void setDataDelimeter(char dataDelimeter) {
        Setting.dataDelimeter = dataDelimeter;
    }

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

    public static int getColumnSize(int idx) {
        return columnsWidth.get(idx);
    }

    public static void setColumnSize(int idx, int size) {
        columnsWidth.add(idx, size);
    }

    public static boolean isSettingValid() {
        int cummulativePageWidth = 0;
        for (Integer width : columnsWidth)
            cummulativePageWidth += width + 2;
        cummulativePageWidth += columnsWidth.size() + 1;

        return pageWidth == cummulativePageWidth;
    }
}
