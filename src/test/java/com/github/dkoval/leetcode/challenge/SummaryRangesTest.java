package com.github.dkoval.leetcode.challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummaryRangesTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        new int[]{0, 1, 2, 4, 5, 7},
                        Arrays.asList("0->2", "4->5", "7")
                ),
                Arguments.of(
                        new int[]{0, 2, 3, 4, 6, 8, 9},
                        Arrays.asList("0", "2->4", "6", "8->9")
                ),
                Arguments.of(
                        new int[0],
                        Collections.<Integer>emptyList()
                ),
                Arguments.of(
                        new int[]{0},
                        Collections.singletonList("0")
                )
        );
    }

    private final SummaryRanges solution = new SummaryRanges();

    @ParameterizedTest
    @MethodSource("input")
    void summaryRanges(int[] nums, List<String> expected) {
        List<String> actual = solution.summaryRanges(nums);
        assertEquals(expected, actual);
    }
}