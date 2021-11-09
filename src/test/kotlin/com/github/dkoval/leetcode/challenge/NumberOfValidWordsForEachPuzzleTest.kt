package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOfValidWordsForEachPuzzleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("aaaa", "asas", "able", "ability", "actt", "actor", "access"),
                arrayOf("aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"),
                listOf(1, 1, 3, 2, 4, 0)
            ),
            Arguments.of(
                arrayOf("apple", "pleas", "please"),
                arrayOf("aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"),
                listOf(0, 1, 3, 2, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return answer array, where answer(i) is the number of words in the given word list that is valid with respect to the puzzles(i)`(
        words: Array<String>,
        puzzles: Array<String>,
        expected: List<Int>
    ) {
        val actual = NumberOfValidWordsForEachPuzzle().findNumOfValidWords(words, puzzles)
        assertEquals(expected, actual)
    }
}