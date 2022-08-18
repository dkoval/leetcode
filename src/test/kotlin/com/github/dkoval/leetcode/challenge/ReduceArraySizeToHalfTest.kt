package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReduceArraySizeToHalf.ReduceArraySizeToHalfRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ReduceArraySizeToHalfTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7),
                2
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 7, 7),
                1
            ),
            Arguments.of(
                intArrayOf(1, 9),
                1
            ),
            Arguments.of(
                intArrayOf(1000, 1000, 3, 7),
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                5
            )
        )
    }

    @Nested
    inner class ReduceArraySizeToHalfRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum size of the set so that at least half of the integers of the array are removed`(
            arr: IntArray,
            expected: Int
        ) {
            ReduceArraySizeToHalfRev1().test(arr, expected)
        }
    }

    private fun ReduceArraySizeToHalf.test(arr: IntArray, expected: Int) {
        val actual = minSetSize(arr)
        assertEquals(expected, actual)
    }
}