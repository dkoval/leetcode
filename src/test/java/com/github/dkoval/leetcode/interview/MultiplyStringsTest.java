package com.github.dkoval.leetcode.interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyStringsTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of("2", "3", "6"),
                Arguments.of("123", "456", "56088")
        );
    }

    private final MultiplyStrings solution = new MultiplyStrings();

    @ParameterizedTest
    @MethodSource("input")
    public void multiply(String num1, String num2, String expected) {
        String actual = solution.multiply(num1, num2);
        assertEquals(expected, actual);
    }
}