package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DuplicateZerosTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        new int[]{1, 0, 2, 3, 0, 4, 5, 0},
                        new int[]{1, 0, 0, 2, 3, 0, 0, 4}
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{1, 2, 3}
                )
        );
    }

    private final DuplicateZeros solution = new DuplicateZeros();

    @ParameterizedTest
    @MethodSource("input")
    void duplicateZeros(int[] arr, int[] expected) {
        solution.duplicateZeros(arr);
        assertArrayEquals(arr, expected);
    }
}