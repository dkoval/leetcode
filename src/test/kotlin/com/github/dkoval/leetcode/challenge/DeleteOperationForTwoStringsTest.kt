package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DeleteOperationForTwoStringsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "sea",
                "eat",
                2
            ),
            Arguments.of(
                "leetcode",
                "etco",
                4
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the minimum number of deletions required to make word1 and word2 the same`(
        word1: String,
        word2: String,
        expected: Int
    ) {
        val actual = DeleteOperationForTwoStrings().minDistance(word1, word2)
        assertEquals(expected, actual)
    }
}