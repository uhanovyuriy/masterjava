package ru.javaops.masterjava.matrix;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BenchmarkMatrix {
    private static final int MATRIX_SIZE = 1000;
    private static final int THREAD_NUMBER = 10;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        org.openjdk.jmh.Main.main(args);

        singleThreadMultiply();

        concurrentMultiply();
    }

    @Benchmark
    public static void singleThreadMultiply() {
        MatrixUtil.singleThreadMultiply(MatrixUtil.create(MATRIX_SIZE), MatrixUtil.create(MATRIX_SIZE));
    }

    @Benchmark
    public static void concurrentMultiply() throws ExecutionException, InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);
        MatrixUtil.concurrentMultiply(MatrixUtil.create(MATRIX_SIZE), MatrixUtil.create(MATRIX_SIZE), executor);
        executor.shutdown();
    }
}
