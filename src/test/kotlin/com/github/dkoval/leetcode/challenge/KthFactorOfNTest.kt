package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KthFactorOfNTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            // Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
            Arguments.of(12, 3, 3),
            // Factors list is [1, 7], the 2nd factor is 7.
            Arguments.of(7, 2, 7),
            // Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
            Arguments.of(4, 4, -1),
            // Factors list is [1], the 1st factor is 1.
            Arguments.of(1, 1, 1),
            // Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000], the 3rd factor is 4.
            Arguments.of(1000, 3, 4)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the kth factor of n`(n: Int, k: Int, expected: Int) {
        val actual = KthFactorOfN().kthFactor(n, k)
        assertEquals(expected, actual)
    }
}