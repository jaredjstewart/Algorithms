package com.jaredjstewart.coursera.princeton.algorithms.week1;

import java.util.Collection;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringConcat {
    public String concatWithStringAddition(Collection<String> strings) {
        String concat = "";

        for (String s : strings) {
            concat += s;
        }

        return concat;
    }

    public String concatWithStringBuilder(Collection<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strings) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    public String concatWithStringBuffer(Collection<String> strings) {
        StringBuffer stringBuffer = new StringBuffer();

        for (String s : strings) {
            stringBuffer.append(s);
        }

        return stringBuffer.toString();
    }

    public String concatWithStringJoiner(Collection<String> strings) {
        StringJoiner stringJoiner = new StringJoiner("");

        for (String s : strings) {
            stringJoiner = stringJoiner.add(s);
        }

        return stringJoiner.toString();
    }

    public String concatWithJoiningCollector(Collection<String> strings) {
        return strings.stream().collect(Collectors.joining());
    }
}