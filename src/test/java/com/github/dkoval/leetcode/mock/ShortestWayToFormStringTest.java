package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestWayToFormStringTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of("abc", "abcbc", 2),
                Arguments.of("abc", "acdbc", -1),
                Arguments.of("xyz", "xzyxz", 3)
        );
    }

    private final ShortestWayToFormString solution = new ShortestWayToFormString();

    @ParameterizedTest
    @MethodSource("input")
    public void shortestWayToFormString(String source, String target, int expected) {
        int actual = solution.shortestWay(source, target);
        assertEquals(expected, actual);
    }
}