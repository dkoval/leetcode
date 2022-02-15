package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WaterBottlesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(9, 3, 13),
            Arguments.of(15, 4, 19)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of water bottles you can drink`(
        numBottles: Int,
        numExchange: Int,
        expected: Int
    ) {
        val actual = WaterBottles().numWaterBottles(numBottles, numExchange)
        assertEquals(expected, actual)
    }
}