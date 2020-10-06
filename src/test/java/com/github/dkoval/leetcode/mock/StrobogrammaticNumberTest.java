package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrobogrammaticNumberTest {

    private final StrobogrammaticNumber solution = new StrobogrammaticNumber();

    static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of("69", true),
                Arguments.of("88", true),
                Arguments.of("962", false),
                Arguments.of("0", true),
                Arguments.of("1", true),
                Arguments.of("2", false),
                Arguments.of("3", false),
                Arguments.of("4", false),
                Arguments.of("5", false),
                Arguments.of("6", false),
                Arguments.of("7", false),
                Arguments.of("8", true),
                Arguments.of("9", false),
                Arguments.of("10", false),
                Arguments.of("11", true)
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    public void shouldDetermineIfNumberIsStrobogrammatic(String num, boolean expected) {
        boolean actual = solution.isStrobogrammatic(num);
        assertEquals(expected, actual);
    }
}