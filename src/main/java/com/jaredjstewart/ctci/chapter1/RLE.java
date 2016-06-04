package com.jaredjstewart.ctci.chapter1;

public class RLE {
    public static  String compress(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        StringBuilder stringBuilder = new StringBuilder();

        int consecutiveCount = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i -1)) {
                consecutiveCount++;
            } else {
                stringBuilder.append(input.charAt(i -1));
                stringBuilder.append(String.valueOf(consecutiveCount));
                consecutiveCount = 1;
            }
        }
        stringBuilder.append(input.charAt(input.length() - 1));
        stringBuilder.append(String.valueOf(consecutiveCount));
        String compressedString = stringBuilder.toString();
        return compressedString.length() < input.length() ? compressedString : input;
    }
}
