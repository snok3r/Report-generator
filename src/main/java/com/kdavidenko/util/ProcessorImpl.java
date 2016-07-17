package com.kdavidenko.util;

import com.kdavidenko.interfaces.DataFileParser;
import com.kdavidenko.interfaces.Processor;
import com.kdavidenko.interfaces.XMLSettingParser;

import java.util.List;

public class ProcessorImpl implements Processor {

    private String[] columnsNames;

    @Override
    public String[] getColumnsNames() {
        return columnsNames;
    }

    @Override
    public void processSetting(String settingsPath) {
        if (!processSetting(settingsPath, new XMLSettingParserImpl())) {
            System.err.print("Setting file is not valid");
            System.exit(-1);
        }
    }

    @Override
    public List<String[]> processDataFile(String dataPath) throws Exception {
        return processDataFile(dataPath, new DataParserImpl());
    }

    private List<String[]> processDataFile(String dataPath, DataFileParser parser) throws Exception {
        parser.parse(dataPath);
        return parser.getResult();
    }

    private boolean processSetting(String settingsPath, XMLSettingParser parser) {
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
}
