package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RangeProductQueriesOfPowers.RangeProductQueriesOfPowersRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RangeProductQueriesOfPowersTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                15,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 2),
                    intArrayOf(0, 3)
                ),
                intArrayOf(2, 4, 64)
            ),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(0, 0)
                ),
                intArrayOf(2)
            )
        )
    }

    @Nested
    inner class RangeProductQueriesOfPowersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the product of powers of 2 in the given range`(
            n: Int,
            queries: Array<IntArray>,
            expected: IntArray
        ) {
            RangeProductQueriesOfPowersRev1().test(n, queries, expected)
        }
    }
}

private fun RangeProductQueriesOfPowers.test(
    n: Int,
    queries: Array<IntArray>,
    expected: IntArray
) {
    val actual = productQueries(n, queries)
    assertArrayEquals(expected, actual)
}
