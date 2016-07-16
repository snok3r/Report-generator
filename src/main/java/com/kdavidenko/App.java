package com.kdavidenko;

import com.kdavidenko.model.Cell;
import com.kdavidenko.model.Document;
import com.kdavidenko.model.Page;
import com.kdavidenko.model.Row;
import com.kdavidenko.util.Setting;
import com.kdavidenko.util.XMLSettingParser;

import java.io.IOException;

public class App {
    private static boolean setUpSetting(String settings) {
        XMLSettingParser parser = new XMLSettingParser();
        try {
            parser.process(settings);
        } catch (Exception e) {
            System.err.println("Couldn't process XML file " + settings + ": " + e.getMessage());
            System.exit(-1);
        }

        Setting.setPageWidth(parser.getWidth());
        Setting.setPageHeight(parser.getHeight());

        Setting.setColumnsNumber(parser.getNumberOfColumns());
        for (int i = 0; i < parser.getNumberOfColumns(); i++)
            Setting.setColumnWidth(i, parser.getColumnWidth(i));

        Page.setHeader(Row.header(parser.getColumnsTitles()));

        return Setting.isSettingValid();
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.err.println("Not enough arguments: " + args.length + " (needed 3)");
            return;
        }

        if (!setUpSetting(args[0])) {
            System.err.print("Setting file is not valid");
            return;
        }

        Document document = new Document();
        Page firstPage = new Page();

        // rows
        Row firstRow = new Row();
        firstRow.addCell(0, new Cell(0, "1"));
        firstRow.addCell(1, new Cell(1, "25/11"));
        firstRow.addCell(2, new Cell(2, "Павлов"));

        Row secondRow = new Row();
        secondRow.addCell(new Cell(0));
        secondRow.addCell(new Cell(1));
        secondRow.addCell(new Cell(2, "Дмитрий"));
        secondRow.setClosingRow(true);

        firstPage.addRow(firstRow);
        firstPage.addRow(secondRow);

        document.addPage(firstPage);

        document.print();

        //document.print(new File(args[2]));
    }
}
