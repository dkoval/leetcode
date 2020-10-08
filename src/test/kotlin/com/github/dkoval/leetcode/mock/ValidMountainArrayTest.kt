package com.github.dkoval.leetcode.mock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidMountainArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(3, 5, 5),
                false
            ),
            Arguments.of(
                intArrayOf(0, 3, 2, 1),
                true
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if a given array is a valid mountain array`(A: IntArray, expected: Boolean) {
        val actual = ValidMountainArray().validMountainArray(A);
        assertEquals(expected, actual)
    }
}