package com.kdavidenko.model;

import com.kdavidenko.interfaces.Document;
import com.kdavidenko.interfaces.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DocumentImpl implements Document {

    private final List<Page> pages;

    DocumentImpl() {
        pages = new ArrayList<Page>();
    }

    @Override
    public void addPage(Page page) {
        pages.add(page);
    }

    @Override
    public List<Page> getPages() {
        return Collections.unmodifiableList(pages);
    }
}
