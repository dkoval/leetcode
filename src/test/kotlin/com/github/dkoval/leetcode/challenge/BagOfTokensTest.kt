package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BagOfTokensTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(100),
                50,
                0
            ),
            Arguments.of(
                intArrayOf(100, 200),
                150,
                1
            ),
            Arguments.of(
                intArrayOf(100, 200, 300, 400),
                200,
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the largest possible score you can achieve after playing any number of tokens`(
        tokens: IntArray,
        P: Int,
        expected: Int
    ) {
        val actual = BagOfTokens().bagOfTokensScore(tokens, P)
        assertEquals(expected, actual)
    }
}