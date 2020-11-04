package com.github.dkoval.leetcode.interview.trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordLadderTest {

    public static List<Arguments> input() {
        return Arrays.asList(
                Arguments.of("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"), 5),
                Arguments.of("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"), 0)
        );
    }

    private final WordLadder solution = new WordLadder();

    @ParameterizedTest
    @MethodSource("input")
    public void ladderLength(String beginWord, String endWord, List<String> wordList, int expected) {
        int actual = solution.ladderLength(beginWord, endWord, wordList);
        assertEquals(expected, actual);
    }
}