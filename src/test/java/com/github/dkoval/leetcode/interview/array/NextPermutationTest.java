package com.github.dkoval.leetcode.interview.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextPermutationTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        new int[]{6, 2, 1, 5, 4, 3, 0},
                        new int[]{6, 2, 3, 0, 1, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{1, 3, 2}
                ),
                Arguments.of(
                        new int[]{3, 2, 1},
                        new int[]{1, 2, 3}
                ),
                Arguments.of(
                        new int[]{1, 1, 5},
                        new int[]{1, 5, 1}
                ),
                Arguments.of(
                        new int[]{1},
                        new int[]{1}
                )
        );
    }

    private final NextPermutation solution = new NextPermutation();

    @ParameterizedTest
    @MethodSource("input")
    void nextPermutation(int[] nums, int[] expected) {
        solution.nextPermutation(nums);
        assertArrayEquals(expected, nums);
    }
}