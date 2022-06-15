package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestStringChainTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf("a", "b", "ba", "bca", "bda", "bdca"),
                // One of the longest word chain is "a","ba","bda","bdca"
                4
            ),
            Arguments.of(
                arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc"),
                5
            ),
            Arguments.of(
                arrayOf("abcd","dbqca"),
                1
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the longest possible length of a word chain with words chosen from the given list of words`(
        words: Array<String>,
        expected: Int
    ) {
        val actual = LongestStringChain().longestStrChain(words)
        assertEquals(expected, actual)
    }
}