package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.challenge.AsteroidCollision
import com.github.dkoval.leetcode.challenge.AsteroidCollision.AsteroidCollisionRev1
import com.github.dkoval.leetcode.challenge.AsteroidCollision.AsteroidCollisionRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AsteroidCollisionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @Nested
    inner class AsteroidCollisionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find out the state of the asteroids after all collisions`(asteroids: IntArray, expected: IntArray) {
            AsteroidCollisionRev1().test(asteroids, expected)
        }
    }

    @Nested
    inner class AsteroidCollisionRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find out the state of the asteroids after all collisions`(asteroids: IntArray, expected: IntArray) {
            AsteroidCollisionRev2().test(asteroids, expected)
        }
    }
}

private fun AsteroidCollision.test(asteroids: IntArray, expected: IntArray) {
    val actual = asteroidCollision(asteroids);
    assertArrayEquals(expected, actual)
}
