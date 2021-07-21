package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PushDominoesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "RR.L",
                "RR.L"
            ),
            Arguments.of(
                ".L.R...LR..L..",
                "LL.RR.LLRRLL.."
            ),
            Arguments.of(
                "L.....RR.RL.....L.R.",
                "L.....RRRRLLLLLLL.RR"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return string representing the final state after dominoes were pushed`(
        dominoes: String,
        expected: String
    ) {
        val actual = PushDominoes().pushDominoes(dominoes)
        assertEquals(expected, actual)
    }
}