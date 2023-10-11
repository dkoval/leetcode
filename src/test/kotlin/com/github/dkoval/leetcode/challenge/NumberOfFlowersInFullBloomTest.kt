package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfFlowersInFullBloom.NumberOfFlowersInFullBloomRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfFlowersInFullBloomTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 6),
                    intArrayOf(3, 7),
                    intArrayOf(9, 12),
                    intArrayOf(4, 13)
                ),
                intArrayOf(2, 3, 7, 11),
                intArrayOf(1, 2, 2, 2)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 10),
                    intArrayOf(3, 3)
                ),
                intArrayOf(3, 3, 2),
                intArrayOf(2, 2, 1)
            )
        )
    }

    @Nested
    inner class NumberOfFlowersInFullBloomRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an integer array answer of size n, where i-th answer is the number of flowers that are in full bloom when the ith person arrives`(
            flowers: Array<IntArray>,
            people: IntArray,
            expected: IntArray
        ) {
            NumberOfFlowersInFullBloomRev1().test(flowers, people, expected)
        }
    }
}

private fun NumberOfFlowersInFullBloom.test(flowers: Array<IntArray>, people: IntArray, expected: IntArray) {
    val actual = fullBloomFlowers(flowers, people)
    assertArrayEquals(expected, actual)
}
