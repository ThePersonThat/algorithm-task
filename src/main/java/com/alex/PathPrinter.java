package com.alex;

import io.bretty.console.table.Alignment;
import io.bretty.console.table.Table;

import java.util.List;

public class PathPrinter {
    private Matrix matrix;
    private List<History.Story> history;

    public PathPrinter(Integer[][] matrix, History history) {
        this.matrix = Matrix.from(matrix);
        this.history = history.getHistoryList();
    }

    public String[][] convertToStringArray() {
        return convert();
    }

    private String[][] convert() {
        String[][] stringMatrix = new String[matrix.getHeight() + 1][matrix.getWidth() + 1];

        for (int i = 0; i <= matrix.getHeight(); i++) {
            for (int j = 0; j <= matrix.getWidth(); j++) {
                int value = matrix.getValue(i, j);
                History.Story story = new History.Story(value, new Coord(i, j));

                if (history.contains(story)) {
                    stringMatrix[j][i] = value + " *";
                    continue;
                }

                stringMatrix[j][i] = Integer.toString(value);
            }
        }

        return stringMatrix;
        /*Table table = Table.of(stringMatrix, Alignment.CENTER, 8);
        return table.toString();*/
    }
}
