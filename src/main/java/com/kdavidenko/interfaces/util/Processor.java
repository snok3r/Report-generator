package com.kdavidenko.interfaces.util;

import java.util.List;

public interface Processor {
    void processSetting(String settingsPath);

    String[] getColumnsNames();

    List<String[]> processDataFile(String dataPath) throws Exception;
}
