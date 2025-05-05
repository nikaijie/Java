package com.thealgorithms.matrix;

import java.util.ArrayList;

/*
 * This is an algorithm for solving the largest absolute eigenvalue of a matrix (square matrix),
 * known as the Power Iteration method. Reference article: https://zhuanlan.zhihu.com/p/447691558
 *
 * */
public final class MatrixEigenvalues {

    private MatrixEigenvalues() {

    }

    // Power iteration method for computing the largest eigenvalue and eigenvecto
    public static Double powerIteration(ArrayList<ArrayList<Double>> matrix, int maxIterations, double tolerance)  {
        int n = matrix.size();
        ArrayList<Double> vector = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vector.add(i == 0 ? 1.0 : 0.0); // 初始化向量
        }
        double eigenvalue = 0.0;
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            ArrayList<Double> newVector = matrixMultiply(matrix, vector);
            double newEigenvalue = vectorNorm(newVector);

            // 归一化向量
            for (int i = 0; i < n; i++) {
                newVector.set(i, newVector.get(i) / newEigenvalue);
            }

            // Check for convergence
            if (Math.abs(newEigenvalue - eigenvalue) < tolerance) {
                break;
            }

            vector = newVector;
            eigenvalue = newEigenvalue;
        }


        return eigenvalue;
    }

    private static ArrayList<Double> matrixMultiply(ArrayList<ArrayList<Double>> matrix, ArrayList<Double> vector) {
        int rows = matrix.size();
        ArrayList<Double> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            double sum = 0.0;
            ArrayList<Double> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                sum += row.get(j) * vector.get(j);
            }
            result.add(sum);
        }
        return result;
    }

    // Calculate the norm of a vector (L2 norm)
    private static double vectorNorm(ArrayList<Double> vector) {
        double sum = 0.0;
        for (double v : vector) {
            sum += v * v;
        }
        return Math.sqrt(sum);
    }


}
