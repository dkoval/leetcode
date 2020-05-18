package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PermutationInStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("ab", "eidbaooo", true),
            Arguments.of("ab", "eidboaoo", false)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if s2 contains the permutation of s1`(s1: String, s2: String, expected: Boolean) {
        val actual = PermutationInString.checkInclusion(s1, s2)
        assertEquals(expected, actual)
    }
}