package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LetterCombinationsOfPhoneNumberTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "",
                listOf<String>()
            ),
            Arguments.of(
                "2",
                listOf("a", "b", "c")
            ),
            Arguments.of(
                "23",
                listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all possible letter combinations that the number could represent`(
        digits: String,
        expected: List<String>
    ) {
        val actual = LetterCombinationsOfPhoneNumber().letterCombinations(digits)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}