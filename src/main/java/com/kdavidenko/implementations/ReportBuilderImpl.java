package com.kdavidenko.implementations;

import com.kdavidenko.implementations.model.DocumentElementsImpl;
import com.kdavidenko.interfaces.Report;
import com.kdavidenko.interfaces.ReportBuilder;
import com.kdavidenko.interfaces.model.Document;
import com.kdavidenko.interfaces.model.DocumentElementsFactory;
import com.kdavidenko.interfaces.model.Page;
import com.kdavidenko.interfaces.model.Row;
import com.kdavidenko.interfaces.util.Processor;
import com.kdavidenko.util.ProcessorImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportBuilderImpl implements ReportBuilder {

    private String[] columnsNames;

    private final DocumentElementsFactory factory = new DocumentElementsImpl();
    private Report report;

    private Document makeDocument(List<Page> pages) {
        Document document = factory.getDocument();

        for (Page page : pages)
            document.addPage(page);

        return document;
    }

    private List<Page> makePages(List<Row> rows) {
        Page firstPage = factory.getPage();

        List<Row> header = makeHeader(columnsNames);

        for (Row row : rows)
            firstPage.addRow(row);

        return Arrays.asList(firstPage);
    }

    private List<Row> makeHeader(String[] columnsNames) {
        List<String[]> data = new ArrayList<String[]>();
        data.add(columnsNames);

        return makeRows(data);
    }

    private List<Row> makeRows(List<String[]> data) {
        Row header = factory.getRow();
        header.addCell(factory.getCell(0, columnsNames[0]));
        header.addCell(factory.getCell(1, columnsNames[1]));
        header.addCell(factory.getCell(2, columnsNames[2]));
        header.setClosingRow(true);

        Row firstRow = factory.getRow();
        firstRow.addCell(0, factory.getCell(0, "1"));
        firstRow.addCell(1, factory.getCell(1, "25/11"));
        firstRow.addCell(2, factory.getCell(2, "Павлов"));

        Row secondRow = factory.getRow();
        secondRow.addCell(factory.getCell(0));
        secondRow.addCell(factory.getCell(1));
        secondRow.addCell(factory.getCell(2, "Дмитрий"));
        secondRow.setClosingRow(true);

        return Arrays.asList(header, firstRow, secondRow);
    }

    @Override
    public void build(String settingPath, String dataPath) throws Exception {

        Processor processor = new ProcessorImpl();
        processor.processSetting(settingPath);
        columnsNames = processor.getColumnsNames();
        List<String[]> processedData = processor.processDataFile(dataPath);

        Document document = makeDocument(makePages(makeRows(processedData)));

        report = new ReportImpl(document);
    }

    @Override
    public Report getReport() {
        return report;
    }
}
