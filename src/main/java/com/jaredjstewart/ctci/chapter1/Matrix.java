package com.jaredjstewart.ctci.chapter1;

public class Matrix {
    private int[][] data;
    int rows, cols;

    public int[][] getData(){
        return data;
    }

    public Matrix (int[][] data) {
        this.data = data;
        rows = data.length;
        cols = data[0].length;
    }

    public Matrix (int rows, int cols){
        this(new int[rows][cols]);
    }

    public Matrix rotateBy90(){
        assert rows == cols;

        Matrix transpose = this.transpose();

        for (int i=0; i < rows; i++){
            transpose.data[i] = reverse(transpose.data[i]);
        }

        return transpose;
    }

    private int[] reverse(int[] row){
        for ( int i = 0; i < row.length / 2; i++) {
            int temp = row[i];
            row[i] = row[ row.length - i - 1];
            row[row.length - i - 1] = temp;
        }

        return row;
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

    public Matrix transpose() {
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               transpose[j][i] = data[i][j];
            }
        }

        return new Matrix(transpose);
    }
}
