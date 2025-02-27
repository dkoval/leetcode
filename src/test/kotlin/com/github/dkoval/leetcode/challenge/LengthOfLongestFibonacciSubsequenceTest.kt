package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LengthOfLongestFibonacciSubsequence.LengthOfLongestFibonacciSubsequenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LengthOfLongestFibonacciSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8),
                5
            ),
            Arguments.of(
                intArrayOf(1, 3, 7, 11, 12, 14, 18),
                3
            ),
            Arguments.of(
                intArrayOf(2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50),
                5
            )
        )
    }

    @Nested
    inner class LengthOfLongestFibonacciSubsequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest Fibonacci-like subsequence of arr`(
            arr: IntArray,
            expected: Int
        ) {
            LengthOfLongestFibonacciSubsequenceRev1().test(arr, expected)
        }
    }
}

private fun LengthOfLongestFibonacciSubsequence.test(arr: IntArray, expected: Int) {
    val actual = lenLongestFibSubseq(arr)
    assertEquals(expected, actual)
}
