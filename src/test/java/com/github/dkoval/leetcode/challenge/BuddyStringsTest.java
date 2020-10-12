package com.github.dkoval.leetcode.challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuddyStringsTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of("ab", "ba", true),
                Arguments.of("ab", "ab", false),
                Arguments.of("aa", "aa", true),
                Arguments.of("aaaaaaabc", "aaaaaaacb", true),
                Arguments.of("", "aa", false)
        );
    }

    private final BuddyStrings solution = new BuddyStrings();

    @ParameterizedTest
    @MethodSource("input")
    public void buddyStrings(String A, String B, boolean expected) {
        boolean actual = solution.buddyStrings(A, B);
        assertEquals(expected, actual);
    }
}