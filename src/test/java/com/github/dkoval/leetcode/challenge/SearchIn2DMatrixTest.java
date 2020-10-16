package com.github.dkoval.leetcode.challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchIn2DMatrixTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60}
                        },
                        3,
                        true
                ),
                Arguments.of(
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60}
                        },
                        13,
                        false
                ),
                Arguments.of(
                        new int[0][],
                        0,
                        false
                )
        );
    }

    private final SearchIn2DMatrix solution = new SearchIn2DMatrix();

    @ParameterizedTest
    @MethodSource("input")
    public void searchMatrix(int[][] matrix, int target, boolean expected) {
        boolean actual = solution.searchMatrix(matrix, target);
        assertEquals(expected, actual);
    }
}