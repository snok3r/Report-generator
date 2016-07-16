package com.kdavidenko.model;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.kdavidenko.util.Settings.*;

public class Document {

    private List<Page> pages;

    public Document() {
        pages = new ArrayList<>();
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public void print() {
        pages.stream()
                .forEach(page -> System.out.print(page.print() + pageDelimeter + endOfLine));
    }

    public void print(File file) {

    }
}
