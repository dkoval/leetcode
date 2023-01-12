package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeToCollectAllApplesInTree.MinimumTimeToCollectAllApplesInTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeToCollectAllApplesInTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)
                ),
                listOf(false, false, true, false, true, true, false),
                8
            ),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)
                ),
                listOf(false, false, true, false, false, true, false),
                6
            ),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)
                ),
                listOf(false, false, false, false, false, false, false),
                0
            )
        )
    }

    @Nested
    inner class MinimumTimeToCollectAllApplesInTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time to collect all apples in a tree`(
            n: Int,
            edges: Array<IntArray>,
            hasApple: List<Boolean>,
            expected: Int
        ) {
            MinimumTimeToCollectAllApplesInTreeRev1().test(n, edges, hasApple, expected)
        }
    }

    private fun MinimumTimeToCollectAllApplesInTree.test(
        n: Int,
        edges: Array<IntArray>,
        hasApple: List<Boolean>,
        expected: Int
    ) {
        val actual = minTime(n, edges, hasApple)
        assertEquals(expected, actual)
    }
}