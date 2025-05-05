package com.thealgorithms.matrix;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * This is a reference article on methods for solving matrix norms:
 * https://www.sciencedirect.com/topics/engineering/matrix-norm
 * */
public class MatrixNorm {



    public MatrixNorm() {
    }

    /*
     *   ||A||₁ = maxⱼ (∑ᵢ |aᵢⱼ|)
     * */
    public static Double matrix1Norm(ArrayList<ArrayList<Double>> matrix) {
        int size = matrix.size();
        Double res = 0.0;
        for (int i = 0; i < size; i++) {
            Double number = Math.abs(matrix.get(i).get(0));
            for (int j = 0; j < size; j++) {
                number = Math.max(number, Math.abs(matrix.get(i).get(j)));
            }
            res += number;
        }
        return res;
    }

    /*
     * ||A||_∞ = max_i (∑ |a_ij|)
     * */
    public static Double matrixInfinityNorm(ArrayList<ArrayList<Double>> matrix) {
        int size = matrix.size();
        Double res = 0.0;
        for (int j = 0; j < size; j++) {
            Double number = Math.abs(matrix.get(0).get(j));
            for (int i = 0; i < size; i++) {
                number = Math.max(number, Math.abs(matrix.get(i).get(j)));
            }
            res += number;
        }

        return res;
    }
    /*
     *||A||₂ = σ_max(A)
     * */
    public static Double matrix2Norm(ArrayList<ArrayList<Double>> matrix)  {
        ArrayList<ArrayList<Double>> transposeMatrix = transposeMatrix(matrix);
        ArrayList<ArrayList<Double>> res=multiplyMatrices(transposeMatrix,matrix);
        Double number = MatrixEigenvalues.powerIteration(res, 1000, 1e-10);
        return Math.sqrt(number);
    }

    public static ArrayList<ArrayList<Double>> transposeMatrix(ArrayList<ArrayList<Double>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();


        ArrayList<ArrayList<Double>> transposed = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            transposed.add(new ArrayList<>());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed.get(j).add(matrix.get(i).get(j));
            }
        }

        return transposed;
    }
    public static ArrayList<ArrayList<Double>> multiplyMatrices(ArrayList<ArrayList<Double>> matrixA, ArrayList<ArrayList<Double>> matrixB) {
        int rowsA = matrixA.size();
        int colsA = matrixA.get(0).size();

        int rowsB = matrixB.size();
        int colsB = matrixB.get(0).size();

        if (colsA != rowsB) {
            throw new IllegalArgumentException("The number of columns in matrix A must be equal to the number of rows in matrix B.");
        }

        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        for (int i = 0; i < rowsA; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0.0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrixA.get(i).get(k) * matrixB.get(k).get(j);
                }
                result.get(i).add(sum);
            }
        }
        return result;
    }

}
