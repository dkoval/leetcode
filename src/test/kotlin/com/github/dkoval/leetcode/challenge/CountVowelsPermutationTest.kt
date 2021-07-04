package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CountVowelsPermutationTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 5),
            Arguments.of(2, 10),
            Arguments.of(5, 68)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count how many strings of length n can be formed following rules`(n: Int, expected: Int) {
        val actual = CountVowelsPermutation().countVowelPermutation(n)
        assertEquals(expected, actual)
    }
}