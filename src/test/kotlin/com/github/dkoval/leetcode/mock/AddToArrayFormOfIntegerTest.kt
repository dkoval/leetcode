package com.github.dkoval.leetcode.mock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AddToArrayFormOfIntegerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2, 0, 0),
                34,
                listOf(1, 2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(2, 7, 4),
                181,
                listOf(4, 5, 5)
            ),
            Arguments.of(
                intArrayOf(2, 1, 5),
                806,
                listOf(1, 0, 2, 1)
            ),
            Arguments.of(
                intArrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9, 9),
                1,
                listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the array-form of the integer X+K`(A: IntArray, k: Int, expected: List<Int>) {
        val actual = AddToArrayFormOfInteger().addToArrayForm(A, k)
        assertEquals(expected, actual)
    }
}