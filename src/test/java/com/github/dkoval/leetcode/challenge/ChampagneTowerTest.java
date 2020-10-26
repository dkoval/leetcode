package com.github.dkoval.leetcode.challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChampagneTowerTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(1, 1, 1, 0.0),
                Arguments.of(2, 1, 1, 0.5),
                Arguments.of(100000009, 33, 17, 1.0)
        );
    }

    private final ChampagneTower solution = new ChampagneTower();

    @ParameterizedTest
    @MethodSource("input")
    void champagneTower(int poured, int query_row, int query_glass, double expected) {
        double actual = solution.champagneTower(poured, query_row, query_glass);
        assertEquals(expected, actual, 1E-6);
    }
}