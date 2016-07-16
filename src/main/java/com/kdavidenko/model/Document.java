package com.kdavidenko.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.*;

public class Document {

    private final List<Page> pages;

    public Document() {
        pages = new ArrayList<Page>();
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public void print() {
        for (Page page : pages) {
            System.out.print(page.print());
            System.out.print(PAGE_DELIMITER + NEXT_LINE);
        }
    }

    public void print(File file) throws IOException {
        print(file, Charset.forName("UTF-16"));
    }

    public void print(File file, Charset charset) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()), charset);
        for (Page page : pages) {
            osw.write(page.print());
            osw.write(PAGE_DELIMITER + NEXT_LINE);
        }
        osw.close();
    }
}
