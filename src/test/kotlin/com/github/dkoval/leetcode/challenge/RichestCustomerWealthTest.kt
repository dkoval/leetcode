package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RichestCustomerWealthTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(3, 2, 1)
                ),
                6
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(7, 3),
                    intArrayOf(3, 5)
                ),
                10
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 8, 7),
                    intArrayOf(7, 1, 3),
                    intArrayOf(1, 9, )
                ),
                17
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the wealth that the richest customer has`(accounts: Array<IntArray>, expected: Int) {
        val actual = RichestCustomerWealth().maximumWealth(accounts)
        assertEquals(expected, actual)
    }
}