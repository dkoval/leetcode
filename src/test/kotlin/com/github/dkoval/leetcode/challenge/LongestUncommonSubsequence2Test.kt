package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestUncommonSubsequence2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("aba", "cdc", "eae"),
                3
            ),
            Arguments.of(
                arrayOf("aba", "cd", "eamaba", "ffty"),
                6
            ),
            Arguments.of(
                arrayOf("aaa", "aaa", "aa"),
                -1
            ),
            Arguments.of(
                arrayOf("a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f"),
                -1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the length of the longest uncommon subsequence in strs`(strs: Array<String>, expected: Int) {
        val actual = LongestUncommonSubsequence2().findLUSlength(strs)
        assertEquals(expected, actual)
    }
}