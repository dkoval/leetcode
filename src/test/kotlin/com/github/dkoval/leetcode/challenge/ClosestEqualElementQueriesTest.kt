package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ClosestEqualElementQueries.ClosestEqualElementQueriesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ClosestEqualElementQueriesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 1, 4, 1, 3, 2),
                intArrayOf(0, 3, 5),
                listOf(2, -1, 3)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(0, 1, 2, 3),
                listOf(-1, -1, -1, -1)
            ),
            Arguments.of(
                intArrayOf(10),
                intArrayOf(0),
                listOf(-1)
            ),
            Arguments.of(
                intArrayOf(18, 18, 18),
                intArrayOf(0, 2),
                listOf(1, 1)
            )
        )
    }

    @Nested
    inner class ClosestEqualElementQueriesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the closest equal element in the circular array for each query`(
            arr: IntArray,
            queries: IntArray,
            expected: List<Int>
        ) {
            ClosestEqualElementQueriesRev1().test(arr, queries, expected)
        }
    }
}

private fun ClosestEqualElementQueries.test(
    nums: IntArray,
    queries: IntArray,
    expected: List<Int>
) {
    val actual = solveQueries(nums, queries)
    assertEquals(expected, actual)
}
