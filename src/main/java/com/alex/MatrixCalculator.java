package com.alex;

public class MatrixCalculator {
    private Matrix originMatrix;
    private Matrix newMatrix;

    public MatrixCalculator(Integer[][] originMatrix) {
        this.originMatrix = Matrix.from(originMatrix);
        this.newMatrix = Matrix.fromEmpty(originMatrix);
    }

    public Integer[][] calculate() {
        firstCalculation();
        calculate(new Coord(newMatrix.getWidth() - 1, 1));

        return newMatrix.getMatrix();
    }

    private void calculate(Coord coord) {
        int value = originMatrix.getValue(coord);
        Max max = Max.findMax(newMatrix, new Coord(coord.getX(), coord.getY() - 1),
                new Coord(coord.getX() + 1, coord.getY() - 1),
                new Coord(coord.getX() + 1, coord.getY()));

        newMatrix.setValue(coord, max.getMaxValue() + value);

        if (coord.getX() == 0 && coord.getY() == newMatrix.getHeight()) {
            return;
        }

        if (coord.getY() == newMatrix.getHeight()) {
            calculate(new Coord(coord.getX() - 1, 1));
        } else {
            calculate(new Coord(coord.getX(), coord.getY() + 1));
        }
    }

    private void firstCalculation() {
        for (int i = 0; i <= newMatrix.getHeight(); i++) {
            if (i == 0) {
                newMatrix.setValueInLastColumn(i, originMatrix.getValueFromLastColumn(i));
                continue;
            }

            int value = originMatrix.getValueFromLastColumn(i) + newMatrix.getValueFromLastColumn(i - 1);
            newMatrix.setValueInLastColumn(i, value);
        }

        for (int i = newMatrix.getWidth(); i >= 0; i--) {
            if (i == newMatrix.getWidth()) {
                continue;
            }

            int value = originMatrix.getValueFromFirstRow(i) + newMatrix.getValueFromFirstRow(i + 1);
            newMatrix.setValueInFirstRow(i, value);
        }
    }
}
