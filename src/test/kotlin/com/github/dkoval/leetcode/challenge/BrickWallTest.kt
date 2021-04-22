package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BrickWallTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    listOf(1, 2, 2, 1),
                    listOf(3, 1, 2),
                    listOf(1, 3, 2),
                    listOf(2, 4),
                    listOf(3, 1, 2),
                    listOf(1, 3, 1, 1)
                ),
                2
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the least number of crossed bricks`(wall: List<List<Int>>, expected: Int) {
        val actual = BrickWall().leastBricks(wall)
        assertEquals(expected, actual)
    }
}