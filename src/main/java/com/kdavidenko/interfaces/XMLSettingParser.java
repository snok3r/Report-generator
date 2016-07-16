package com.kdavidenko.interfaces;

public interface XMLSettingParser {
    void process(String fileName) throws Exception;

    int getWidth();

    int getHeight();

    String getColumnTitle(int idx);

    String[] getColumnsTitles();

    int getColumnWidth(int idx);

    int getNumberOfColumns();
}
