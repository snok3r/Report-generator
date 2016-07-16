package com.kdavidenko.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.*;

public class Document {

    private List<Page> pages;

    public Document() {
        pages = new ArrayList<Page>();
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public void print() {
        for (Page page : pages) {
            System.out.print(page.print());
            System.out.print(Page.printPageDelimeter() + endOfLine);
        }
    }

    public void print(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        for (Page page : pages) {
            bw.write(page.print());
            bw.write(Page.printPageDelimeter() + endOfLine);
        }
        bw.close();
    }
}
