package com.github.dkoval.leetcode.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddBoldTagInStringTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of(
                        "abcxyz123",
                        new String[]{"abc", "123"},
                        "<b>abc</b>xyz<b>123</b>"
                ),
                Arguments.of(
                        "aaabbcc",
                        new String[]{"aaa", "aab", "bc"},
                        "<b>aaabbc</b>c"
                )
        );
    }

    private final AddBoldTagInString solution = new AddBoldTagInString();

    @ParameterizedTest
    @MethodSource("input")
    public void shouldAddClosedPairOfBoldTag(String s, String[] dict, String expected) {
        String actual = solution.addBoldTag(s, dict);
        assertEquals(expected, actual);
    }
}