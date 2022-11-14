package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MostStonesRemovedWithSameRowOrColumn.MostStonesRemovedWithSameRowOrColumnUsingDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MostStonesRemovedWithSameRowOrColumnTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 1),
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(2, 2)
                ),
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 2),
                    intArrayOf(1, 1),
                    intArrayOf(2, 0),
                    intArrayOf(2, 2)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0)
                ),
                0
            )
        )
    }

    @Nested
    inner class MostStonesRemovedWithSameRowOrColumnUsingDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest possible number of stones that can be removed`(
            stones: Array<IntArray>,
            expected: Int
        ) {
            MostStonesRemovedWithSameRowOrColumnUsingDFS().test(stones, expected)
        }
    }

    private fun MostStonesRemovedWithSameRowOrColumn.test(stones: Array<IntArray>, expected: Int) {
        val actual = removeStones(stones)
        assertEquals(expected, actual)
    }
}