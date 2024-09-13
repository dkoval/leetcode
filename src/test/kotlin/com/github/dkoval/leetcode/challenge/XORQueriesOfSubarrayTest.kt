package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.XORQueriesOfSubarray.XORQueriesOfSubarrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class XORQueriesOfSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4, 8),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(0, 3),
                    intArrayOf(3, 3)
                ),
                intArrayOf(2, 7, 14, 8)
            ),
            Arguments.of(
                intArrayOf(4, 8, 2, 10),
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(1, 3),
                    intArrayOf(0, 0),
                    intArrayOf(0, 3)
                ),
                intArrayOf(8, 0, 4, 4)
            )
        )
    }

    @Nested
    inner class XORQueriesOfSubarrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return answers to queries`(arr: IntArray, queries: Array<IntArray>, expected: IntArray) {
            XORQueriesOfSubarrayRev1().test(arr, queries, expected)
        }
    }
}

private fun XORQueriesOfSubarray.test(arr: IntArray, queries: Array<IntArray>, expected: IntArray) {
    val actual = xorQueries(arr, queries)
    assertArrayEquals(expected, actual)
}
