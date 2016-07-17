package com.kdavidenko.interfaces.model;

import java.util.List;

public interface Document {
    void addPage(Page page);

    List<Page> getPages();
}
