package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class HammingDistanceTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 4, 2),
            Arguments.of(3, 5, 2)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should calculate the Hamming distance`(x: Int, y: Int, expected: Int) {
        val actual = HammingDistance.hammingDistance(x, y)
        assertEquals(expected, actual)
    }
}