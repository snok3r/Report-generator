package com.kdavidenko;

import com.kdavidenko.model.Document;
import com.kdavidenko.model.Page;
import com.kdavidenko.util.Settings;

public class App {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.err.println("Not enough arguments " + args.length + ", need 3");
            return;
        }

        Settings.setPageWidth(32);
        Settings.setPageHeight(12);
        Settings.setDataDelimeter('\t');

        Settings.setColumnsNumber(3);
        Settings.setColumnSize(0, 8);
        Settings.setColumnSize(1, 7);
        Settings.setColumnSize(2, 7);

        Document document = new Document();
        document.addPage(new Page());
        document.addPage(new Page());

        document.print();
    }
}
