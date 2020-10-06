package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WiggleSortTest {

    private final WiggleSort solution = new WiggleSort();

    static List<Arguments> input() {
        return Collections.singletonList(
                Arguments.of(
                        new int[]{3, 5, 2, 1, 6, 4},
                        new int[]{1, 3, 2, 5, 4, 6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void verifyRequiredReordering(int[] nums, int[] expected) {
        solution.wiggleSort(nums);
        assertArrayEquals(expected, nums);
    }
}