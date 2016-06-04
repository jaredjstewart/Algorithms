package com.jaredjstewart.ctci.chapter1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void times() throws Exception {
         int[][] aData = {{1, 2, 3}, {4,5,6}, {7,8,9}};

      Matrix result =  new Matrix(aData);
        System.out.println(Arrays.deepToString(result.rotateBy90().getData()));

    }

}