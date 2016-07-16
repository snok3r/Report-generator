package com.kdavidenko.util;

import com.kdavidenko.interfaces.XMLSettingParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLSettingParserImpl implements XMLSettingParser {

    private int width;
    private int height;
    private final List<Column> columnsSetting = new ArrayList<Column>();

    @Override
    public void process(String fileName) throws Exception {
        Document doc = buildDoc(fileName);
        processPageSetting(doc.getElementsByTagName("page").item(0));
        processColumns(doc.getElementsByTagName("column"));
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getColumnTitle(int idx) {
        return columnsSetting.get(idx).title;
    }

    @Override
    public String[] getColumnsTitles() {
        String[] titles = new String[getNumberOfColumns()];
        for (int i = 0; i < titles.length; i++)
            titles[i] = getColumnTitle(i);

        return titles;
    }

    @Override
    public int getColumnWidth(int idx) {
        return columnsSetting.get(idx).width;
    }

    @Override
    public int getNumberOfColumns() {
        return columnsSetting.size();
    }

    private Document buildDoc(String filePath) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();

        return builder.parse(filePath);
    }

    private void processPageSetting(Node page) {
        if (page.getNodeType() == Node.ELEMENT_NODE) {
            Element p = (Element) page;

            width = Integer.valueOf(p.getElementsByTagName("width").item(0).getTextContent());
            height = Integer.valueOf(p.getElementsByTagName("height").item(0).getTextContent());
        }
    }

    private void processColumns(NodeList columns) {
        for (int i = 0; i < columns.getLength(); i++)
            processColumn(columns.item(i));
    }

    private void processColumn(Node column) {
        if (column.getNodeType() == Node.ELEMENT_NODE) {
            Element c = (Element) column;

            String title = c.getElementsByTagName("title").item(0).getTextContent();
            int width = Integer.valueOf(c.getElementsByTagName("width").item(0).getTextContent());
            columnsSetting.add(new Column(title, width));
        }
    }

    private class Column {
        final String title;
        final int width;

        public Column(String title, int width) {
            this.title = title;
            this.width = width;
        }
    }
}
