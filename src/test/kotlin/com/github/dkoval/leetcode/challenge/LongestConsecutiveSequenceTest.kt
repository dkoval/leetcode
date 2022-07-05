package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestConsecutiveSequence.LongestConsecutiveSequenceRev1
import com.github.dkoval.leetcode.challenge.LongestConsecutiveSequence.LongestConsecutiveSequenceRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestConsecutiveSequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                0
            ),
            Arguments.of(
                intArrayOf(100, 4, 200, 1, 3, 2),
                4
            ),
            Arguments.of(
                intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1),
                9
            ),
            Arguments.of(
                intArrayOf(1, 2, 0, 1),
                3
            )
        )
    }

    @Nested
    inner class LongestConsecutiveSequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the length of the longest consecutive elements sequence`(nums: IntArray, expected: Int) {
            LongestConsecutiveSequenceRev1().test(nums, expected)
        }
    }

    @Nested
    inner class LongestConsecutiveSequenceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the length of the longest consecutive elements sequence`(nums: IntArray, expected: Int) {
            LongestConsecutiveSequenceRev2().test(nums, expected)
        }
    }

    private fun LongestConsecutiveSequence.test(nums: IntArray, expected: Int) {
        val actual = longestConsecutive(nums)
        assertEquals(expected, actual)
    }
}