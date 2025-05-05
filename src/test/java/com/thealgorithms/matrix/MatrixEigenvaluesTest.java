package com.thealgorithms.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixEigenvaluesTest {

    ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
    //This is an active test case.
    @Test
    void matrixEigenvaluesTest01() {

        matrix.add(new ArrayList<Double>() {{
            add(-3.0);
            add(1.0);
            add(-1.0);
        }});
        matrix.add(new ArrayList<Double>() {{
            add(-7.0);
            add(5.0);
            add(-1.0);
        }});
        matrix.add(new ArrayList<Double>() {{
            add(-6.0);
            add(6.0);
            add(-2.0);
        }});
        // Calculate the largest eigenvalue
        Double eigenvalues = MatrixEigenvalues.powerIteration(matrix, 1000, 1e-10);
        System.out.println("largest eigenvalue：" + eigenvalues);

    }

    @Test
    void matrixEigenvaluesTest02() {
        Scanner scanner = new Scanner(System.in);
        Integer number = 0;
        System.out.println("Please enter a number to represent the number of rows and columns of the matrix.");
        while (true) {
            System.out.println("Please enter a number to represent the number of rows and columns of the matrix.");
            number = scanner.nextInt();
            if (number > 0) break;
            else System.out.println("Matrix does not exist. Please enter a positive number.");
        }
        initMatrix(number);
        Double eigenvalues = MatrixEigenvalues.powerIteration(matrix, 1000, 1e-10);
        System.out.println("largest eigenvalue：" + eigenvalues);

    }

    void initMatrix(Integer n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            ArrayList<Double> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextDouble());
            }
            matrix.add(row);
        }
    }
}
