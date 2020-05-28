package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountingBitsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                2,
                intArrayOf(0, 1, 1)
            ),
            Arguments.of(
                5,
                intArrayOf(0, 1, 1, 2, 1, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should calculate the number of 1 bits for every number in the range from 1 to N`(
        num: Int,
        expected: IntArray
    ) {
        val actual = CountingBits.countBits(num)
        assertArrayEquals(expected, actual)
    }
}