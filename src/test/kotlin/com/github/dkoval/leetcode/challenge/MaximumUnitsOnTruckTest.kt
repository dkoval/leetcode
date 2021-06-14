package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumUnitsOnTruckTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 2),
                    intArrayOf(3, 1)
                ),
                4,
                8
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 10),
                    intArrayOf(2, 5),
                    intArrayOf(4, 7),
                    intArrayOf(3, 9)
                ),
                10,
                91
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum total number of units that can be put on the truck`(
        boxTypes: Array<IntArray>,
        truckSize: Int,
        expected: Int
    ) {
        val actual = MaximumUnitsOnTruck().maximumUnits(boxTypes, truckSize)
        assertEquals(expected, actual)
    }
}