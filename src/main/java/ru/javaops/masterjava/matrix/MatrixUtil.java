package ru.javaops.masterjava.matrix;

import java.util.*;
import java.util.concurrent.*;

/**
 * gkislin
 * 03.07.2016
 */
public class MatrixUtil {

    // TODO implement parallel multiplication matrixA*matrixB
    public static int[][] concurrentMultiply(int[][] matrixA, int[][] matrixB, ExecutorService executor) throws InterruptedException, ExecutionException {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];
        final int[][] tMatrixB = getTMatrix(matrixB, matrixSize);

        final CompletionService<List<Integer[]>> completionService = new ExecutorCompletionService<>(executor);
        final List<Future<List<Integer[]>>> futures = new ArrayList<>();

        for (int i = 0; i < matrixSize; i++) {
            final int rowNum = i;
            final Future<List<Integer[]>> future = completionService.submit(() -> {
                final List<Integer[]> list = new ArrayList<>();
                for (int j = 0; j < matrixSize; j++) {
                    final Integer[] row = new Integer[3];
                    int sum = 0;
                    for (int k = 0; k < matrixSize; k++) {
                        sum += matrixA[rowNum][k] * tMatrixB[j][k];
                    }
                    row[0] = rowNum;
                    row[1] = j;
                    row[2] = sum;
                    list.add(row);
                }

                return list;
            });

            futures.add(future);
        }

        while(!futures.isEmpty()) {
            Future<List<Integer[]>> future = completionService.poll(5, TimeUnit.SECONDS);
            if (future == null) {
                System.out.println("Alarm, future = null!!!");
                return matrixC;
            }

            future.get().forEach(arr -> matrixC[arr[0]][arr[1]] = arr[2]);

            futures.remove(future);
        }

        return matrixC;
    }

    // TODO optimize by https://habrahabr.ru/post/114797/
    public static int[][] singleThreadMultiply(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        final int[][] matrixC = new int[matrixSize][matrixSize];
        final int[][] tMatrixB = getTMatrix(matrixB, matrixSize);

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int sum = 0;
                for (int k = 0; k < matrixSize; k++) {
                    sum += matrixA[i][k] * tMatrixB[j][k];
                }
                matrixC[i][j] = sum;
            }
        }
        return matrixC;
    }

    public static int[][] getTMatrix(final int[][] matrix, final int matrixSize) {
        final int[][] tMatrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                tMatrix[j][i] = matrix[i][j];
            }
        }
        return tMatrix;
    }

    public static int[][] create(int size) {
        int[][] matrix = new int[size][size];
        Random rn = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rn.nextInt(10);
            }
        }
        return matrix;
    }

    public static boolean compare(int[][] matrixA, int[][] matrixB) {
        final int matrixSize = matrixA.length;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
