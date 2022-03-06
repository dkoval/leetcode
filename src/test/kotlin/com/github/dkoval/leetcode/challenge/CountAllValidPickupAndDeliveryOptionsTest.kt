package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountAllValidPickupAndDeliveryOptionsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1, 1),
            Arguments.of(2, 6),
            Arguments.of(3, 90),
            Arguments.of(4, 2520),
            Arguments.of(5, 113400),
            Arguments.of(6, 7484400),
            Arguments.of(7, 681080400),
            Arguments.of(8, 729647433)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should count all valid pickup-delivery possible sequences such that delivery(i) is always after of pickup(i)`(
        n: Int,
        expected: Int
    ) {
        val actual = CountAllValidPickupAndDeliveryOptions().countOrders(n)
        assertEquals(expected, actual)
    }
}