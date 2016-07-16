package com.kdavidenko.interfaces;

import java.util.List;

public interface Document {
    void addPage(Page page);

    List<Page> getPages();
}
