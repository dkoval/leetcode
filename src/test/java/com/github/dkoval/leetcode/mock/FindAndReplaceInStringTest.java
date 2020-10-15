package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAndReplaceInStringTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        "abcd",
                        new int[]{0, 2},
                        new String[]{"a", "cd"},
                        new String[]{"eee", "ffff"},
                        "eeebffff"
                ),
                Arguments.of(
                        "abcd",
                        new int[]{0, 2},
                        new String[]{"ab","ec"},
                        new String[]{"eee","ffff"},
                        "eeecd"
                )
        );
    }

    private final FindAndReplaceInString solution = new FindAndReplaceInString();

    @ParameterizedTest
    @MethodSource("input")
    void findReplaceString(String S, int[] indexes, String[] sources, String[] targets, String expected) {
        String actual = solution.findReplaceString(S, indexes, sources, targets);
        assertEquals(expected, actual);
    }
}