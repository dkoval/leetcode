package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ReorderRoutesToMakeAllPathsLeadToTheCityZero.ReorderRoutesToMakeAllPathsLeadToTheCityZeroBFS
import com.github.dkoval.leetcode.problems.ReorderRoutesToMakeAllPathsLeadToTheCityZero.ReorderRoutesToMakeAllPathsLeadToTheCityZeroDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(4, 0),
                    intArrayOf(4, 5)
                ),
                3
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(3, 2),
                    intArrayOf(3, 4)
                ),
                2
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 0)
                ),
                0
            )
        )
    }

    @Nested
    inner class ReorderRoutesToMakeAllPathsLeadToTheCityZeroDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of edges changed`(n: Int, connections: Array<IntArray>, expected: Int) {
            ReorderRoutesToMakeAllPathsLeadToTheCityZeroDFS().test(n, connections, expected)
        }
    }

    @Nested
    inner class ReorderRoutesToMakeAllPathsLeadToTheCityZeroBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of edges changed`(n: Int, connections: Array<IntArray>, expected: Int) {
            ReorderRoutesToMakeAllPathsLeadToTheCityZeroBFS().test(n, connections, expected)
        }
    }
}

private fun ReorderRoutesToMakeAllPathsLeadToTheCityZero.test(n: Int, connections: Array<IntArray>, expected: Int) {
    val actual = minReorder(n, connections)
    assertEquals(expected, actual)
}
