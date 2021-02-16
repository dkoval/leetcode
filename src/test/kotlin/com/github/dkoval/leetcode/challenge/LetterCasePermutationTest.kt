package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LetterCasePermutationTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "a1b2",
                listOf("a1b2", "a1B2", "A1b2", "A1B2")
            ),
            Arguments.of(
                "3z4",
                listOf("3z4", "3Z4")
            ),
            Arguments.of(
                "12345",
                listOf("12345")
            ),
            Arguments.of(
                "0",
                listOf("0")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a list of all possible letter case permutations`(S: String, expected: List<String>) {
        val actual = LetterCasePermutation().letterCasePermutation(S)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}