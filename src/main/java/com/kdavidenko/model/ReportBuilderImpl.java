package com.kdavidenko.model;

import com.kdavidenko.interfaces.Report;
import com.kdavidenko.interfaces.ReportBuilder;
import com.kdavidenko.interfaces.XMLSettingParser;
import com.kdavidenko.util.Setting;
import com.kdavidenko.util.XMLSettingParserImpl;

public class ReportBuilderImpl implements ReportBuilder {

    private String[] columnsNames;
    private Report report;

    private boolean setUpSetting(String settingsPath, XMLSettingParser parser) {
        try {
            parser.parse(settingsPath);
        } catch (Exception e) {
            System.err.println("Couldn't parse XML file " + settingsPath + ": " + e.getMessage());
            System.exit(-1);
        }

        Setting.setPageWidth(parser.getWidth());
        Setting.setPageHeight(parser.getHeight());

        Setting.setColumnsNumber(parser.getNumberOfColumns());
        for (int i = 0; i < parser.getNumberOfColumns(); i++)
            Setting.setColumnWidth(i, parser.getColumnWidth(i));

        columnsNames = parser.getColumnsTitles();

        return Setting.isSettingValid();
    }

    @Override
    public void build(String settingPath, String dataPath) {
        if (!setUpSetting(settingPath, new XMLSettingParserImpl())) {
            System.err.print("Setting file is not valid");
            return;
        }

        report = new ReportImpl(columnsNames);
    }

    @Override
    public Report getReport() {
        return report;
    }
}
