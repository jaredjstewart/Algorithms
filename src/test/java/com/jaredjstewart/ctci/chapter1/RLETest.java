package com.jaredjstewart.ctci.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class RLETest {
    @Test
    public void compressWorksTypicalCase() throws Exception {
        String input = "aabcccccaaa";
        String expectedOutput = "a2b1c5a3";

        assertEquals(expectedOutput,RLE.compress(input));
    }

    @Test
    public void compressGivesOriginalStringWhenLonger() throws Exception {
        String input = "abc";
        String expectedOutput = "abc";

        assertEquals(expectedOutput,RLE.compress(input));
    }

    @Test
    public void compressWorksForSingleChar() throws Exception {
        String input = "a";
        String expectedOutput = "a";

        assertEquals(expectedOutput,RLE.compress(input));
    }
}