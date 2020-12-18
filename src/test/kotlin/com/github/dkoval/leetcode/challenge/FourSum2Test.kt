package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FourSum2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(1, 2),
                intArrayOf(-2, -1),
                intArrayOf(-1, 2),
                intArrayOf(0, 2),
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should compute how many tuples (i, j, k, l) there are such that A_i + B_j + C_k + D_k is zero`(
        A: IntArray,
        B: IntArray,
        C: IntArray,
        D: IntArray,
        expected: Int
    ) {
        val actual = FourSum2().fourSumCount(A, B, C, D)
        assertEquals(expected, actual)
    }
}