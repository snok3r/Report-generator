package com.kdavidenko.model;

import com.kdavidenko.interfaces.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import static com.kdavidenko.util.Setting.NEXT_LINE;
import static com.kdavidenko.util.Setting.PAGE_DELIMITER;

class ReportImpl implements Report {

    private Document document;

    ReportImpl(String[] columnsNames) {
        DocumentElementsFactory factory = new DocumentElementsImpl();
        document = factory.getDocument();
        Page firstPage = factory.getPage();

        Row header = factory.getRow();
        header.addCell(factory.getCell(0, columnsNames[0]));
        header.addCell(factory.getCell(1, columnsNames[1]));
        header.addCell(factory.getCell(2, columnsNames[2]));
        header.setClosingRow(true);

        // rows
        Row firstRow = factory.getRow();
        firstRow.addCell(0, factory.getCell(0, "1"));
        firstRow.addCell(1, factory.getCell(1, "25/11"));
        firstRow.addCell(2, factory.getCell(2, "Павлов"));

        Row secondRow = factory.getRow();
        secondRow.addCell(factory.getCell(0));
        secondRow.addCell(factory.getCell(1));
        secondRow.addCell(factory.getCell(2, "Дмитрий"));
        secondRow.setClosingRow(true);

        firstPage.addRow(header);
        firstPage.addRow(firstRow);
        firstPage.addRow(secondRow);

        document.addPage(firstPage);
    }

    @Override
    public void print() {
        for (Page page : document.getPages()) {
            System.out.print(page.print());
            System.out.print(PAGE_DELIMITER + NEXT_LINE);
        }
    }

    @Override
    public void print(File file) throws IOException {
        print(file, Charset.forName("UTF-16"));
    }

    @Override
    public void print(File file, Charset charset) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()), charset);
        for (Page page : document.getPages()) {
            osw.write(page.print());
            osw.write(PAGE_DELIMITER + NEXT_LINE);
        }
        osw.close();
    }
}
