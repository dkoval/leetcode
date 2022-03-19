package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DungeonGame.DungeonGameDPJava
import com.github.dkoval.leetcode.challenge.DungeonGame.DungeonGameRecursiveWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DungeonGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(-2, -3, 3),
                    intArrayOf(-5, -10, 1),
                    intArrayOf(10, 30, -5)
                ),
                7
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-5)
                ),
                6
            )
        )
    }

    @Nested
    inner class DungeonGameDPTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the knight's minimum initial health so that he is able to rescue the princess`(
            dungeon: Array<IntArray>,
            expected: Int
        ) {
            DungeonGameDP.test(dungeon, expected)
        }
    }

    @Nested
    inner class DungeonGameDPJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the knight's minimum initial health so that he is able to rescue the princess`(
            dungeon: Array<IntArray>,
            expected: Int
        ) {
            DungeonGameDPJava().test(dungeon, expected)
        }
    }

    @Nested
    inner class DungeonGameRecursiveWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the knight's minimum initial health so that he is able to rescue the princess`(
            dungeon: Array<IntArray>,
            expected: Int
        ) {
            DungeonGameRecursiveWithMemoization().test(dungeon, expected)
        }
    }

    private fun DungeonGame.test(dungeon: Array<IntArray>, expected: Int) {
        val actual = calculateMinimumHP(dungeon)
        assertEquals(expected, actual)
    }
}