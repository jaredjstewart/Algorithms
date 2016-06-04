package com.jaredjstewart.ctci.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReplaceStringCharactersTest {
    @Test
    public void replaceSpacesInString()  {
        char[] input = "Mr John Smith    ".toCharArray();
        char[] expectedOutput = "Mr%20John%20Smith".toCharArray();
        assertArrayEquals(expectedOutput,  ReplaceStringCharacters.replaceSpacesInString(input,13));
    }

}