package com.implementation.algorithms.game.tictactoe;

public class Cell {

    private String cellValue;
    private int rowNumber;
    private int columnNumber;

    public Cell(String cellValue, int rowNumber, int columnNumber) {
        this.cellValue = cellValue;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

}
