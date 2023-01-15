package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfGoodPaths.NumberOfGoodPathsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfGoodPathsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2, 1, 3),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4)
                ),
                6
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 2, 3),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(2, 4)
                ),
                7
            ),
            Arguments.of(
                intArrayOf(1),
                emptyArray<IntArray>(),
                1
            )
        )
    }

    @Nested
    inner class NumberOfGoodPathsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct good paths`(vals: IntArray, edges: Array<IntArray>, expected: Int) {
            NumberOfGoodPathsRev1().test(vals, edges, expected)
        }
    }

    private fun NumberOfGoodPaths.test(vals: IntArray, edges: Array<IntArray>, expected: Int) {
        val actual = numberOfGoodPaths(vals, edges)
        assertEquals(expected, actual)
    }
}
