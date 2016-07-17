package com.kdavidenko.implementations;

import com.kdavidenko.Setting;
import com.kdavidenko.implementations.model.DocumentElementsImpl;
import com.kdavidenko.interfaces.Report;
import com.kdavidenko.interfaces.ReportBuilder;
import com.kdavidenko.interfaces.model.*;
import com.kdavidenko.interfaces.util.Processor;
import com.kdavidenko.util.FileProcessor;

import java.util.*;

import static com.kdavidenko.Setting.columnsNumber;
import static com.kdavidenko.Setting.pageHeight;

public class ReportBuilderImpl implements ReportBuilder {

    private String[] columnsNames;

    private final DocumentElementsFactory factory = DocumentElementsImpl.getFactory();
    private Report report;

    private Document makeDocument(List<Page> pages) {
        Document document = factory.getDocument();

        for (Page page : pages)
            document.addPage(page);

        return document;
    }

    private List<Page> makePages(List<Row> rows) {

        List<Page> pages = new ArrayList<Page>();

        List<Row> header = makeHeader(columnsNames);
        if (header.size() + 1 >= pageHeight) {
            System.err.println("Couldn't fit header with given page-height " + pageHeight);
            System.exit(-1);
        }

        Iterator<Row> rowIterator = rows.iterator();
        while (rowIterator.hasNext()) {
            Page newPage = makePage(header, rowIterator);
            pages.add(newPage);
        }

        return pages;
    }

    private Page makePage(List<Row> header, Iterator<Row> rowIterator) {

        Page currentPage = factory.getPage();
        insertHeader(currentPage, header);

        Row currentRow = factory.getRow(); // empty row
        int currentPageRowIdx = header.size() + 1; // + row_delimiter (1 row)
        while (currentPageRowIdx < pageHeight && rowIterator.hasNext()) {

            currentRow = rowIterator.next();
            currentPage.addRow(currentRow);

            if (currentRow.hasRowDelimiter())
                currentPageRowIdx++;

            currentPageRowIdx++;
        }

        // remove row delimiter,
        // if it is the last on the page
        if (currentPageRowIdx > pageHeight)
            currentRow.setRowDelimiter(false);

        // add page delimiter,
        // if it is the last row on the page
        if (currentPageRowIdx >= pageHeight)
            currentPage.setEnded(true);

        return currentPage;
    }

    private void insertHeader(Page page, List<Row> header) {
        for (Row headerRow : header)
            page.addRow(headerRow);
    }

    private List<Row> makeHeader(String[] columnsNames) {
        List<String[]> data = new ArrayList<String[]>();
        data.add(columnsNames);

        return makeRows(data);
    }

    private List<Row> makeRows(List<String[]> data) {

        List<Row> rows = new ArrayList<Row>();

        for (String[] line : data)
            rows.addAll(turnSingleLineOfDataIntoRows(line));

        return rows;
    }

    private List<Row> turnSingleLineOfDataIntoRows(String[] line) {

        List<Row> rows = new ArrayList<Row>();

        Row currentRow = null;
        for (List<Cell> row : collectDataIntoRows(line).values()) {
            currentRow = factory.getRow();

            for (Cell cell : row)
                currentRow.addCell(cell.getCellIndex(), cell);

            rows.add(currentRow);
        }

        if (currentRow != null)
            currentRow.setRowDelimiter(true);

        return rows;
    }

    private Map<Integer, List<Cell>> collectDataIntoRows(String[] data) {
        Map<Integer, List<Cell>> rowsData = new LinkedHashMap<Integer, List<Cell>>();

        for (int i = 0; i < data.length; i++) {
            List<String> cellData = FileProcessor.splitToLines(data[i], Setting.getColumnWidth(i));

            for (int j = 0; j < cellData.size(); j++) {
                if (rowsData.get(j) == null)
                    rowsData.put(j, new ArrayList<Cell>(columnsNumber));
                rowsData.get(j).add(factory.getCell(i, cellData.get(j)));
            }
        }

        return rowsData;
    }

    @Override
    public void build(String settingPath, String dataPath) throws Exception {

        Processor processor = new FileProcessor();
        processor.processSetting(settingPath);
        columnsNames = processor.getColumnsNames();

        List<String[]> processedData = processor.processDataFile(dataPath);

        Document document = makeDocument(makePages(makeRows(processedData)));
        this.report = new ReportImpl(document);
    }

    @Override
    public Report getReport() {
        return report;
    }
}
