package com.kdavidenko;

import com.kdavidenko.interfaces.*;
import com.kdavidenko.model.*;
import com.kdavidenko.model.Header;
import com.kdavidenko.util.Setting;
import com.kdavidenko.util.XMLSettingParserImpl;

import java.io.File;
import java.io.IOException;

public class Generator {
    private static Row header;

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

        header = new Header(parser.getColumnsTitles());

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

        Document document = new DocumentImpl();
        Page firstPage = new PageImpl();
        firstPage.setHeader(header);

        // rows
        Row firstRow = new RowImpl();
        firstRow.addCell(0, new CellImpl(0, "1"));
        firstRow.addCell(1, new CellImpl(1, "25/11"));
        firstRow.addCell(2, new CellImpl(2, "Павлов"));

        Row secondRow = new RowImpl();
        secondRow.addCell(new CellImpl(0));
        secondRow.addCell(new CellImpl(1));
        secondRow.addCell(new CellImpl(2, "Дмитрий"));
        secondRow.setClosingRow(true);

        firstPage.addRow(firstRow);
        firstPage.addRow(secondRow);

        document.addPage(firstPage);

        document.print();

        //document.print(new File(args[2]));
    }
}
