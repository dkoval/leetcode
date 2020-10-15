package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeIntervalsTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        new int[][]{
                                {1, 3},
                                {2, 6},
                                {8, 10},
                                {15, 18}
                        },
                        new int[][]{
                                {1, 6},
                                {8, 10},
                                {15, 18}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 4},
                                {4, 5}
                        },
                        new int[][]{
                                {1, 5}
                        }
                )
        );
    }

    private final MergeIntervals solution = new MergeIntervals();

    @ParameterizedTest
    @MethodSource("input")
    void merge(int[][] intervals, int[][] expected) {
        int[][] actual = solution.merge(intervals);
        assertArrayEquals(expected, actual);
    }
}