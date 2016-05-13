package com.jaredjstewart.coursera.princeton.algorithms.week4;

import com.jaredjstewart.coursera.princeton.algorithms.week4.ShellSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShellSortTest {
    @Test
    public void sortArray1() throws Exception {
        Integer[] input = {4,6,5};
        Integer[] sortedInput = {4,5,6};

        ShellSort.sort(input);

        assertArrayEquals(sortedInput,  input);
    }

    @Test
    public void sortArray2() throws Exception {
        Integer[] input = {9,8,7,6,5,4,3,2,1,0,-1};
        Integer[] sortedInput = {-1,0,1,2,3,4,5,6,7,8,9};

        ShellSort.sort(input);

        assertArrayEquals(sortedInput,  input);
    }

}