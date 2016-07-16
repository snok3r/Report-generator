package com.kdavidenko;

import com.kdavidenko.interfaces.*;
import com.kdavidenko.model.*;
import com.kdavidenko.util.Setting;
import com.kdavidenko.util.XMLSettingParserImpl;

import java.io.IOException;

public class Generator {
    private static Header header;

    private static DocumentElementsFactory factory = new DocumentElementsImpl();

    private static boolean setUpSetting(String settingsPath, XMLSettingParser parser) {
        try {
            parser.process(settingsPath);
        } catch (Exception e) {
            System.err.println("Couldn't process XML file " + settingsPath + ": " + e.getMessage());
            System.exit(-1);
        }

        Setting.setPageWidth(parser.getWidth());
        Setting.setPageHeight(parser.getHeight());

        Setting.setColumnsNumber(parser.getNumberOfColumns());
        for (int i = 0; i < parser.getNumberOfColumns(); i++)
            Setting.setColumnWidth(i, parser.getColumnWidth(i));

        header = factory.getHeader(parser.getColumnsTitles());

        return Setting.isSettingValid();
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.err.println("Not enough arguments: " + args.length + " (needed 3)");
            return;
        }

        if (!setUpSetting(args[0], new XMLSettingParserImpl())) {
            System.err.print("Setting file is not valid");
            return;
        }

        Document document = factory.getDocument();
        Page firstPage = factory.getPage();
        firstPage.setHeader(header);

        // rows
        Row firstRow = factory.getRow();
        firstRow.addCell(0, factory.getCell(0).setData("1"));
        firstRow.addCell(1, factory.getCell(1).setData("25/11"));
        firstRow.addCell(2, factory.getCell(2).setData("Павлов"));

        Row secondRow = factory.getRow();
        secondRow.addCell(factory.getCell(0));
        secondRow.addCell(factory.getCell(1));
        secondRow.addCell(factory.getCell(2).setData("Дмитрий"));
        secondRow.setClosingRow(true);

        firstPage.addRow(firstRow);
        firstPage.addRow(secondRow);

        document.addPage(firstPage);

        document.print();

        //document.print(new File(args[2]));
    }
}
