package com.alex;

public class Max {
    private Coord coord;
    private int maxValue;

    public Max(Coord coord, int maxValue) {
        this.coord = coord;
        this.maxValue = maxValue;
    }

    public Coord getCoord() {
        return coord;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public static Max findMax(Matrix matrix, Coord... coords) {
        int max = Integer.MIN_VALUE;
        Coord maxCoord = null;

        for (Coord coord : coords) {
            int value = matrix.getValue(coord);

            if (value >= max) {
                max = value;
                maxCoord = coord;
            }
        }

        return new Max(maxCoord, max);
    }

    public static Max fromCoord(Matrix matrix, Coord coord) {
        return new Max(coord, matrix.getValue(coord));
    }
}
