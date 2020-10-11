package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfusingNumberTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(6, true),
                Arguments.of(89, true),
                Arguments.of(11, false),
                Arguments.of(25, false)
        );
    }

    private final ConfusingNumber solution = new ConfusingNumber();

    @ParameterizedTest
    @MethodSource("input")
    public void confusingNumber(int N, boolean expected) {
        boolean actual = solution.confusingNumber(N);
        assertEquals(expected, actual);
    }
}