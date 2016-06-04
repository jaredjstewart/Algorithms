package com.jaredjstewart.ctci.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void times() throws Exception {
         int[][] aData = {{1, 2}, {3, 4}};
        int[][] rotationMatrixData = {{0, -1}, {1, 0}};


      Matrix result =  new Matrix(aData).times(new Matrix(rotationMatrixData));


        assertEquals( 2,  aData[0][1]);


    }

}