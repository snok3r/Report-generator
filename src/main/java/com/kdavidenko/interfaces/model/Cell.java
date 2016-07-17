package com.kdavidenko.interfaces.model;

public interface Cell {

    int getCellIndex();

    Cell setData(String data);

    String getData();

    boolean isEmpty();

    String print();
}
