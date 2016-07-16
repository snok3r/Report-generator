package com.kdavidenko.interfaces;

public interface ReportBuilder {
    void build(String settingPath, String dataPath);

    Report getReport();
}
