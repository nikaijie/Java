package com.thealgorithms.matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixNormTest {

    ArrayList<ArrayList<Double>> matrix = new ArrayList<>();

    @Test
    void matrix_Norm_test01()  {
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
        Double res_1Norm = MatrixNorm.matrix1Norm(matrix);
        Double res_2Norm = MatrixNorm.matrix2Norm(matrix);
        Double resInfinityNorm = MatrixNorm.matrixInfinityNorm(matrix);
        System.out.println("the result_1Norn is: " + res_1Norm);
        System.out.println("the result_2Norn is: " + res_2Norm);
        System.out.println("the resInfinityNorm is: " + resInfinityNorm);

    }
    //This is an active test case.
    @Test
    void matrix_Norm_test02()  {
        matrix.add(new ArrayList<Double>() {{ add(-3.0); add(1.0); add(-1.0); }});
        matrix.add(new ArrayList<Double>() {{ add(-7.0); add(5.0); add(-1.0); }});
        matrix.add(new ArrayList<Double>() {{ add(-6.0); add(6.0); add(-2.0); }});
        Double res_1Norm = MatrixNorm.matrix1Norm(matrix);
        Double res_2Norm = MatrixNorm.matrix2Norm(matrix);
        Double resInfinityNorm = MatrixNorm.matrixInfinityNorm(matrix);
        System.out.println("the result_1Norn is: " + res_1Norm);
        System.out.println("the result_2Norn is: " + res_2Norm);
        System.out.println("the resInfinityNorm is: " + resInfinityNorm);
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
