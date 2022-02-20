package com.alex;

public class PathFinder {
    private Matrix matrix;
    private History history;

    public PathFinder(Integer[][] matrix) {
        this.matrix = Matrix.from(matrix);
        history = new History();
    }

    public int find() {
        Coord coord = new Coord(0, matrix.getHeight());
        int value = matrix.getValue(coord);
        history.addStory(new History.Story(value, coord));

        return find(coord, value);
    }

    public History getHistory() {
        return history;
    }

    private int find(Coord coord, int sum) {
        Max maxValue = null;

        if (coord.getX() == matrix.getWidth() && coord.getY() == 0) {
            return sum;
        }

        if (coord.getY() == 0) {
            maxValue = Max.fromCoord(matrix, new Coord(coord.getX() + 1, coord.getY()));
        }

        if (coord.getX() == matrix.getWidth()) {
            maxValue = Max.fromCoord(matrix, new Coord(coord.getX(), coord.getY() - 1));
        }

        if (maxValue == null) {
            maxValue = Max.findMax(matrix, new Coord(coord.getX() + 1, coord.getY()),
                    new Coord(coord.getX() + 1, coord.getY() - 1), new Coord(coord.getX(), coord.getY() - 1));
        }

        int value = sum + maxValue.getMaxValue();
        history.addStory(new History.Story(value, maxValue.getCoord()));
        return find(maxValue.getCoord(), value);
    }
}
