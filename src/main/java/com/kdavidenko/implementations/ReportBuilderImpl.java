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

        for (int currentRowIdx = 0; currentRowIdx < rows.size(); ) {

            Page currentPage = factory.getPage();
            Row currentRow = null;
            insertHeader(currentPage, header);

            int currentPageRowIdx = header.size() + 1; // + row_delimiter (1 row)
            while (currentPageRowIdx < pageHeight && currentRowIdx < rows.size()) {

                currentRow = rows.get(currentRowIdx);
                currentPage.addRow(currentRow);

                if (currentRow.isClosingRow())
                    currentPageRowIdx++;

                currentPageRowIdx++;
                currentRowIdx++;
            }

            if (currentPageRowIdx > pageHeight)
                currentRow.setClosingRow(false);

            if (currentPageRowIdx >= pageHeight)
                currentPage.setEnded(true);

            pages.add(currentPage);
        }

        return pages;
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

        for (String[] cellsData : data) {
            Map<Integer, List<Cell>> rowsData = new LinkedHashMap<Integer, List<Cell>>();

            for (int i = 0; i < cellsData.length; i++) {
                List<String> cellData = FileProcessor.splitToLines(cellsData[i], Setting.getColumnWidth(i));

                for (int j = 0; j < cellData.size(); j++) {
                    if (rowsData.get(j) == null)
                        rowsData.put(j, new ArrayList<Cell>(columnsNumber));
                    rowsData.get(j).add(factory.getCell(i, cellData.get(j)));
                }
            }

            Row newRow = null;
            for (List<Cell> row : rowsData.values()) {
                newRow = factory.getRow();
                for (Cell cell : row)
                    newRow.addCell(cell.getCellIndex(), cell);
                rows.add(newRow);
            }
            newRow.setClosingRow(true);
        }

        return rows;
    }

    @Override
    public void build(String settingPath, String dataPath) throws Exception {

        Processor processor = new FileProcessor();
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
