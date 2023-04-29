package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckingExistenceOfEdgeLengthLimitedPaths.CheckingExistenceOfEdgeLengthLimitedPathsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckingExistenceOfEdgeLengthLimitedPathsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 4), intArrayOf(2, 0, 8), intArrayOf(1, 0, 16)),
                arrayOf(intArrayOf(0, 1, 2), intArrayOf(0, 2, 5)),
                booleanArrayOf(false, true)
            ),
            Arguments.of(
                5,
                arrayOf(intArrayOf(0, 1, 10), intArrayOf(1, 2, 5), intArrayOf(2, 3, 9), intArrayOf(3, 4, 13)),
                arrayOf(intArrayOf(0, 4, 14), intArrayOf(1, 4, 13)),
                booleanArrayOf(true, false)
            )
        )
    }

    @Nested
    inner class CheckingExistenceOfEdgeLengthLimitedPathsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check for existence of edge length limited paths`(
            n: Int,
            edgeList: Array<IntArray>,
            queries: Array<IntArray>,
            expected: BooleanArray
        ) {
            CheckingExistenceOfEdgeLengthLimitedPathsRev1().test(n, edgeList, queries, expected)
        }
    }
}

private fun CheckingExistenceOfEdgeLengthLimitedPaths.test(
    n: Int,
    edgeList: Array<IntArray>,
    queries: Array<IntArray>,
    expected: BooleanArray
) {
    val actual = distanceLimitedPathsExist(n, edgeList, queries)
    assertArrayEquals(expected, actual)
}
