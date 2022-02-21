package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PrimeArrangementsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(5, 12),
            Arguments.of(10, 17280),
            Arguments.of(100, 682289015)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of permutations of 1 to n so that prime numbers are at prime indices`(
        n: Int,
        expected: Int
    ) {
        val actual = PrimeArrangements().numPrimeArrangements(n)
        assertEquals(expected, actual)
    }
}