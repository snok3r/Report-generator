package com.kdavidenko;

import com.kdavidenko.model.Cell;
import com.kdavidenko.model.Document;
import com.kdavidenko.model.Page;
import com.kdavidenko.model.Row;
import com.kdavidenko.util.Setting;

import java.io.IOException;

public class App {
    private static boolean setUpSetting() {
        Setting.setPageWidth(32);
        Setting.setPageHeight(12);
        Setting.setDataDelimeter('\t');

        Setting.setColumnsNumber(3);
        Setting.setColumnSize(0, 8);
        Setting.setColumnSize(1, 7);
        Setting.setColumnSize(2, 7);

        if (!Setting.isSettingValid())
            return false;

        Page.setHeader(Row.header(new String[]{"Номер", "Дата", "ФИО"}));

        return true;
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.err.println("Not enough arguments: " + args.length + " (needed 3)");
            return;
        }

        if (!setUpSetting()) {
            System.err.print("Setting is not valid (wrong number of spaces)");
            return;
        }

        Document document = new Document();
        Page firstPage = new Page();

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
