package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FrequencyOfMostFrequentElement.FrequencyOfMostFrequentElementSlidingWindow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FrequencyOfMostFrequentElementTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 4),
                5,
                3
            ),
            Arguments.of(
                intArrayOf(1, 4, 8, 13),
                5,
                2
            ),
            Arguments.of(
                intArrayOf(3, 9, 6),
                2,
                1
            )
        )
    }

    @Nested
    inner class FrequencyOfMostFrequentElementSlidingWindowTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible frequency of an element after performing at most k operations`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            FrequencyOfMostFrequentElementSlidingWindow().test(nums, k, expected)
        }
    }

    private fun FrequencyOfMostFrequentElement.test(nums: IntArray, k: Int, expected: Int) {
        val actual = maxFrequency(nums, k)
        assertEquals(expected, actual)
    }
}