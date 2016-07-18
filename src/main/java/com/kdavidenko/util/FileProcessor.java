package com.kdavidenko.util;

import com.kdavidenko.Setting;
import com.kdavidenko.interfaces.util.DataFileParser;
import com.kdavidenko.interfaces.util.Processor;
import com.kdavidenko.interfaces.util.XMLSettingParser;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor implements Processor {

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
        return processDataFile(dataPath, new DataFileParserImpl(), Charset.forName("UTF-16"));
    }

    @Override
    public List<String[]> processDataFile(String dataPath, Charset charset) throws Exception {
        return processDataFile(dataPath, new DataFileParserImpl(), charset);
    }

    private List<String[]> processDataFile(String dataPath, DataFileParser parser, Charset charset) throws Exception {
        parser.parse(dataPath, charset);
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

    public static List<String> splitToLines(String stringToSplit, int maxLineLength) {

        String[] words = stringToSplit.split("(?<=[^а-яА-Яa-zA-Z0-9])");
        StringBuilder sb = new StringBuilder();

        List<String> result = new ArrayList<String>(words.length);

        for (String word : words) {
            if (word.trim().length() + sb.length() <= maxLineLength)
                sb.append(word);
            else {
                if (sb.length() > 0) {
                    result.add(sb.toString().trim());
                    sb.setLength(0);
                }

                String overflow = word;
                while (overflow.length() > maxLineLength) {
                    result.add(overflow.substring(0, maxLineLength));
                    overflow = overflow.substring(maxLineLength);
                }
                sb.append(overflow);
            }
        }
        result.add(sb.toString().trim());

        return result;
    }
}
