package com.jaredstewart.algs4part1.week1;


import com.jaredjstewart.coursera.princeton.algorithms.week1.StringConcat;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class StringConcatBenchmark {


    @State(Scope.Benchmark)
    public static class BenchmarkState {
        StringConcat stringConcat = new StringConcat();
    }

    private Collection<String> createListOfStrings(int size) {
        final Collection<String> strings = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            strings.add("Hello JMH !");
        }

        return strings;
    }

    @Param({"100", "10000"})
    public int size;

    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public String concatWithStringAddition(BenchmarkState state) {
        return state.stringConcat.concatWithStringAddition(createListOfStrings(size));
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public String concatWithStringBuilder(BenchmarkState state) {
        return state.stringConcat.concatWithStringBuilder(createListOfStrings(size));
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public String concatWithStringBuffer(BenchmarkState state) {
        return state.stringConcat.concatWithStringBuffer(createListOfStrings(size));
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public String concatWithStringJoiner(BenchmarkState state) {
        return state.stringConcat.concatWithStringJoiner(createListOfStrings(size));
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public String concatWithJoiningCollector(BenchmarkState state) {
        return state.stringConcat.concatWithJoiningCollector(createListOfStrings(size));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringConcatBenchmark.class.getSimpleName())
                .param("size", "10000")
                .warmupIterations(2)
                .measurementIterations(2)
                .build();

        new Runner(opt).run();
    }
}