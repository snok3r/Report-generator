package com.kdavidenko.util;

import java.util.ArrayList;
import java.util.List;

public class Settings {
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
        Settings.dataDelimeter = dataDelimeter;
    }

    public static void setPageWidth(int pageWidth) {
        Settings.pageWidth = pageWidth;
    }

    public static void setPageHeight(int pageHeight) {
        Settings.pageHeight = pageHeight;
    }

    public static void setColumnsNumber(int columnsNumber) {
        Settings.columnsNumber = columnsNumber;
        columnsWidth = new ArrayList<>(columnsNumber);
    }

    public static int getColumnSize(int idx) {
        return columnsWidth.get(idx);
    }

    public static void setColumnSize(int idx, int size) {
        columnsWidth.add(idx, size);
    }
}
