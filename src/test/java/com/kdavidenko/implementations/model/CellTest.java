package com.kdavidenko.implementations.model;

import com.kdavidenko.interfaces.model.Cell;
import com.kdavidenko.interfaces.model.DocumentElementsFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    private Cell emptyCell;
    private Cell cellWithEmptyData;
    private Cell cellWithData;

    private int cellIndex = 0;
    private String data = "data";

    private DocumentElementsFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = DocumentElementsImpl.getFactory();

        emptyCell = factory.getCell(cellIndex);
        cellWithEmptyData = factory.getCell(cellIndex, "");
        cellWithData = factory.getCell(cellIndex, data);
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(emptyCell.isEmpty());
        assertTrue(cellWithEmptyData.isEmpty());

        assertFalse(cellWithData.isEmpty());
    }

    @Test
    public void getData() throws Exception {
        assertEquals("", emptyCell.getData());
        assertEquals("", cellWithEmptyData.getData());
        assertEquals(data, cellWithData.getData());
    }

    @Test
    public void getCellIndex() throws Exception {
        assertEquals(cellIndex, emptyCell.getCellIndex());
        assertEquals(cellIndex, cellWithData.getCellIndex());
    }
}