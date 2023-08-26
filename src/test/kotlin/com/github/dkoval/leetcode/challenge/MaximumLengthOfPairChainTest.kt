package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumLengthOfPairChain.MaximumLengthOfPairChainRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumLengthOfPairChainTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(7, 8),
                    intArrayOf(4, 5)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-10, -8),
                    intArrayOf(8, 9),
                    intArrayOf(-5, 0),
                    intArrayOf(6, 10),
                    intArrayOf(-6, -4),
                    intArrayOf(1, 7),
                    intArrayOf(9, 10),
                    intArrayOf(-4, 7)
                ),
                4
            )
        )
    }

    @Nested
    inner class MaximumLengthOfPairChainRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length longest chain which can be formed`(pairs: Array<IntArray>, expected: Int) {
            MaximumLengthOfPairChainRev1().test(pairs, expected)
        }
    }
}

private fun MaximumLengthOfPairChain.test(pairs: Array<IntArray>, expected: Int) {
    val actual = findLongestChain(pairs)
    assertEquals(expected, actual)
}
