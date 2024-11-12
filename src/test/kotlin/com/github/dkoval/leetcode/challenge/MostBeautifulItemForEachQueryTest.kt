package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MostBeautifulItemForEachQuery.MostBeautifulItemForEachQueryRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MostBeautifulItemForEachQueryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 2),
                    intArrayOf(2, 4),
                    intArrayOf(5, 6),
                    intArrayOf(3, 5)
                ),
                intArrayOf(1, 2, 3, 4, 5, 6),
                intArrayOf(2, 4, 5, 5, 6, 6)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4)
                ),
                intArrayOf(1),
                intArrayOf(4)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 1000),
                ),
                intArrayOf(5),
                intArrayOf(0)
            )
        )
    }

    @Nested
    inner class MostBeautifulItemForEachQueryRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return  an array answer of the same length as queries where answer(i) is the answer to the i-th query`(
            items: Array<IntArray>,
            queries: IntArray,
            expected: IntArray
        ) {
            MostBeautifulItemForEachQueryRev1().test(items, queries, expected)
        }
    }
}

private fun MostBeautifulItemForEachQuery.test(items: Array<IntArray>, queries: IntArray, expected: IntArray) {
    val actual = maximumBeauty(items, queries)
    assertArrayEquals(expected, actual)
}
