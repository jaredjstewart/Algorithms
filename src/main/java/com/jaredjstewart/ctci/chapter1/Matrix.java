package com.jaredjstewart.ctci.chapter1;

public class Matrix {
    private int[][] data;
    int rows, cols;

    public Matrix (int[][] data) {
        this.data = data;
    }

    public Matrix (int rows, int cols){
        this(new int[rows][cols]);
    }

    public Matrix times(Matrix that) {
        assert this.cols == that.rows;

        int[][] result = new int[this.rows][this.cols];

        for (int i = 0; i < this.rows; i++) {
            for(int j = 0; j < that.cols; j++) {
                for (int k = 0; k < this.cols; k ++) {
                    result[i][j] += this.data[i][k] * that.data[k][j];
                }
            }
        }

        return new Matrix(result);
    }
}
