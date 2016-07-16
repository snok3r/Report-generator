package com.kdavidenko.model;

import com.kdavidenko.interfaces.Document;
import com.kdavidenko.interfaces.Page;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.kdavidenko.util.Setting.*;

public class DocumentImpl implements Document {

    private final List<Page> pages;

    public DocumentImpl() {
        pages = new ArrayList<Page>();
    }

    @Override
    public void addPage(Page page) {
        pages.add(page);
    }

    @Override
    public void print() {
        for (Page page : pages) {
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
        for (Page page : pages) {
            osw.write(page.print());
            osw.write(PAGE_DELIMITER + NEXT_LINE);
        }
        osw.close();
    }
}
