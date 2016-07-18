package com.kdavidenko.implementations.model;

import com.kdavidenko.interfaces.model.Cell;
import com.kdavidenko.interfaces.model.DocumentElementsFactory;
import com.kdavidenko.interfaces.model.Row;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RowTest {

    private Row emptyRow;
    private Row rowWithData;

    private Cell emptyCell;
    private int emptyCellIndex = 0;

    private Cell cellWithData;
    private int cellWithDataIndex = 1;

    private String data = "data";

    private DocumentElementsFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = DocumentElementsImpl.getFactory();

        emptyCell = factory.getCell(emptyCellIndex);
        cellWithData = factory.getCell(cellWithDataIndex, data);

        emptyRow = factory.getRow();

        rowWithData = factory.getRow();
        rowWithData.addCell(emptyCell);
        rowWithData.addCell(cellWithData);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getCellFromEmptyRow() throws Exception {
        emptyRow.getCell(-1);
        emptyRow.getCell(0);
    }

    @Test
    public void getCellFromRow() throws Exception {
        assertEquals(emptyCell, rowWithData.getCell(emptyCellIndex));
        assertEquals(cellWithData, rowWithData.getCell(cellWithDataIndex));

        assertEquals("", rowWithData.getCellData(emptyCellIndex));
        assertEquals(data, rowWithData.getCellData(cellWithDataIndex));
    }

}