package com.kdavidenko.implementations;

import com.kdavidenko.interfaces.*;
import com.kdavidenko.interfaces.model.Document;
import com.kdavidenko.interfaces.model.Page;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import static com.kdavidenko.Setting.NEXT_LINE;

class ReportImpl implements Report {

    private final Document document;

    ReportImpl(Document document) {
        this.document = document;
    }

    @Override
    public void print() {
        for (Page page : document.getPages()) {
            System.out.print(page.print());
            System.out.print(NEXT_LINE);
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
            osw.write(NEXT_LINE);
        }
        osw.close();
    }
}
