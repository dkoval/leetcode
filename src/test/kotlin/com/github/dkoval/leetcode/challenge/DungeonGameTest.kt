package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DungeonGameTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(-2, -3, 3),
                    intArrayOf(-5, -10, 1),
                    intArrayOf(10, 30, -5)
                ),
                7
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should determine the knight's minimum initial health so that he is able to rescue the princess`(
        dungeon: Array<IntArray>,
        expected: Int
    ) {
        val actual = DungeonGame.calculateMinimumHP(dungeon)
        assertEquals(expected, actual)
    }
}