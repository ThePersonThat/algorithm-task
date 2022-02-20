package com.alex;

import io.bretty.console.table.Alignment;
import io.bretty.console.table.Table;

public class App {
    public static void main(String[] args) {
        /*Integer[][] matrix = {
                {3, -1, 4, 4, -2, -3, 4, 7},
                {-1, 2, -2, -1, 6, 2, -3, 2},
                {2, -1, 5, 3, -1, 2, -1, 3},
                {1, -2, 5, 3, 3, -4, -4, 7},
                {-2, 4, -2, 3, -5, 1, -3, -4},
                {-3, -2, -1, -5, 3, 1, -3, -2},
                {-2, -3, -2, 3, -2, 3, -1, -5},
                {3, -1, -2, -3, -2, -1, 4, 3}
        };*/
        Integer[][] matrix = {
                {2, -1, 5, 4, -2, -3, 4, 6},
                {-1, 2, -1, -1, 6, 2, -3, 1},
                {1, -1, 4, 3, -1, 2, -1, 4},
                {3, -2, 6, 3, 3, -4, -4, 6},
                {-1, 4, -1, 3, -5, 1, -3, -3},
                {-2, -2, -1, -5, 3, 1, -3, -1},
                {-1, -3, -1, 3, -2, 3, -1, -3},
                {4, -1, -1, -3, -2, -1, 4, 2}
        };
        MatrixCalculator calculator = new MatrixCalculator(matrix);
        Integer[][] calculatedMatrix = calculator.calculate();
        PathFinder finder = new PathFinder(calculatedMatrix);
        int prize = finder.find();
        PathPrinter pathPrinter = new PathPrinter(calculatedMatrix, finder.getHistory());
        String[][] pathMatrix = pathPrinter.convertToStringArray();

        printMatrix(matrix, "ORIGINAL MATRIX");
        printMatrix(calculatedMatrix, "CALCULATED MATRIX");
        printMatrix(pathMatrix, "PATH MATRIX (*)");
        System.out.println("\nMAX PRIZE = " + prize);
    }


    private static <T> void printMatrix(T[][] matrix, String title) {
        System.out.println("\n++++  " + title + " ++++");
        Table table = Table.of(matrix, Alignment.CENTER, 5);
        System.out.println(table);
    }
}
