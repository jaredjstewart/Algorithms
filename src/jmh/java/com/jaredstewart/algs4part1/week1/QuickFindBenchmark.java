package com.jaredstewart.algs4part1.week1;

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
public class QuickFindBenchmark {

//
//    @State(Scope.Benchmark)
//    public static class BenchmarkState {
//        QuickFind quickFind = new QuickFind();
//    }
//
//    private Collection<String> createListOfStrings(int size) {
//        final Collection<String> strings = new ArrayList<>(size);
//
//        for (int i = 0; i < size; i++) {
//            strings.add("Hello JMH !");
//        }
//
//        return strings;
//    }
//
//    @Param({"100", "10000"})
//    public int size;
//
//    @Benchmark
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 1)
//    public String concatWithStringAddition(BenchmarkState state) {
//        return state.stringConcat.concatWithStringAddition(createListOfStrings(size));
//    }
//
//    @Benchmark
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 1)
//    public String concatWithStringBuilder(BenchmarkState state) {
//        return state.stringConcat.concatWithStringBuilder(createListOfStrings(size));
//    }
//
//    @Benchmark
//    @Warmup(iterations = 1)
//    @Measurement(iterations = 1)
//    public String concatWithStringBuffer(BenchmarkState state) {
//        return state.stringConcat.concatWithStringBuffer(createListOfStrings(size));
//    }
//
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(QuickFindBenchmark.class.getSimpleName())
//                .param("size", "10000")
//                .warmupIterations(2)
//                .measurementIterations(2)
//                .build();
//
//        new Runner(opt).run();
//    }
}