package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.challenge.AsteroidCollision
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class AsteroidCollisionTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(5, 10, -5),
                intArrayOf(5, 10)
            ),
            Arguments.of(
                intArrayOf(8, -8),
                intArrayOf()
            ),
            Arguments.of(
                intArrayOf(10, 2, -5),
                intArrayOf(10)
            ),
            Arguments.of(
                intArrayOf(-2, -1, 1, 2),
                intArrayOf(-2, -1, 1, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find out the state of the asteroids after all collisions`(asteroids: IntArray, expected: IntArray) {
        val actual = AsteroidCollision().asteroidCollision(asteroids);
        assertArrayEquals(expected, actual)
    }
}