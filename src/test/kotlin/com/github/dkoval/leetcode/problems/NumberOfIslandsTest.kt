package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NumberOfIslandsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    charArrayOf('1','1','1','1','0'),
                    charArrayOf('1','1','0','1','0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','0','0','0')
                ),
                1,
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('1','1','0','0','0'),
                    charArrayOf('0','0','1','0','0'),
                    charArrayOf('0','0','0','1','1')
                ),
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of islands`(grid: Array<CharArray>, expected: Int) {
        val actual = NumberOfIslands().numIslands(grid)
        assertEquals(expected, actual)
    }
}