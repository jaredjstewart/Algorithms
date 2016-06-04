package com.jaredjstewart.ctci.chapter1;

public class ReplaceStringCharacters {
    public static char[] replaceSpacesInString(char[] input, int length) {
        int spaceCount = countSpaces(input, length);
        int newLength = length + 2 * spaceCount;

        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[newLength - 1] = '0';
                input[newLength - 2] = '2';
                input[newLength - 3] = '%';
                newLength = newLength -3;
            } else {
                input[newLength - 1] = input[i];
                newLength = newLength -1;
            }
        }

        return input;
    }

    private static int countSpaces(char[] input, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') count++;
        }
        return count;
    }

}
