package com.alex;

public class Matrix {
    private int width;
    private int height;
    private Integer[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setValue(int x, int y, int value) {
        matrix[y][x] = value;
    }

    public int getValue(int x, int y) {
        return matrix[y][x];
    }

    public int getValueFromLastColumn(int y) {
        int x = width;
        return getValue(x, y);
    }

    public int getValueFromLastRow(int x) {
        int y = height;
        return getValue(x, y);
    }

    public void setValueInLastColumn(int y, int value) {
        int x = width;
        setValue(x, y, value);
    }

    public void setValueInLastRow(int x, int value) {
        int y = height;
        setValue(x, y, value);
    }

    public int getValueFromFirstColumn(int y) {
        return getValue(0, y);
    }

    public int getValueFromFirstRow(int x) {
        return getValue(x, 0);
    }

    public void setValueInFirstRow(int x, int value) {
        setValue(x, 0, value);
    }

    public void setValueInFirstColumn(int y, int value) {
        setValue(0, y, value);
    }

    public void setValue(Coord coord, int value) {
        int x = coord.getX();
        int y = coord.getY();

        setValue(x, y, value);
    }

    public int getValue(Coord coord) {
        int x = coord.getX();
        int y = coord.getY();

        return getValue(x, y);
    }

    public static Matrix from(Integer[][] matrix) {
        return new Matrix(matrix[0].length - 1, matrix.length - 1, matrix);
    }

    public static Matrix fromEmpty(Integer[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        return new Matrix(width - 1, height - 1, new Integer[width][height]);
    }

    private Matrix(int width, int height, Integer[][] matrix) {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }
}
