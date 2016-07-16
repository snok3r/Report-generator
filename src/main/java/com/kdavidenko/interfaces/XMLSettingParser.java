package com.kdavidenko.interfaces;

public interface XMLSettingParser {
    void parse(String fileName) throws Exception;

    int getWidth();

    int getHeight();

    String getColumnTitle(int idx);

    String[] getColumnsTitles();

    int getColumnWidth(int idx);

    int getNumberOfColumns();
}
