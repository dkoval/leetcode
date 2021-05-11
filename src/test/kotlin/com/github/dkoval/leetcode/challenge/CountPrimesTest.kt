package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountPrimesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                10,
                4
            ),
            Arguments.of(
                0,
                0
            ),
            Arguments.of(
                1,
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count the number of prime numbers less than n`(n: Int, expected: Int) {
        val actual = CountPrimes().countPrimes(n)
        assertEquals(expected, actual)
    }
}