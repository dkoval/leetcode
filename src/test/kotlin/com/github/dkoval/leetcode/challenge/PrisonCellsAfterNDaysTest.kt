package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PrisonCellsAfterNDaysTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(0, 1, 0, 1, 1, 0, 0, 1),
                7,
                intArrayOf(0, 0, 1, 1, 0, 0, 0, 0)
            ),
            Arguments.of(
                intArrayOf(1, 0, 0, 1, 0, 0, 1, 0),
                1_000_000_000,
                intArrayOf(0, 0, 1, 1, 1, 1, 1, 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the state of the prison after N days`(cells: IntArray, N: Int, expected: IntArray) {
        val actual = PrisonCellsAfterNDays.prisonAfterNDays(cells, N)
        assertArrayEquals(expected, actual)
    }
}