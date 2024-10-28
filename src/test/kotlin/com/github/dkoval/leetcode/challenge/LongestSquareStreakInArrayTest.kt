package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestSquareStreakInArray.LongestSquareStreakInArrayRev1
import com.github.dkoval.leetcode.challenge.LongestSquareStreakInArray.LongestSquareStreakInArrayRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestSquareStreakInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 3, 6, 16, 8, 2),
                3
            ),
            Arguments.of(
                intArrayOf(2, 3, 5, 6, 7),
                -1
            ),
            Arguments.of(
                intArrayOf(4, 16, 256, 65536),
                4
            )
        )
    }

    @Nested
    inner class LongestSquareStreakInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest square streak in nums`(nums: IntArray, expected: Int) {
            LongestSquareStreakInArrayRev1().test(nums, expected)
        }
    }

    @Nested
    inner class LongestSquareStreakInArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest square streak in nums`(nums: IntArray, expected: Int) {
            LongestSquareStreakInArrayRev2().test(nums, expected)
        }
    }
}

private fun LongestSquareStreakInArray.test(nums: IntArray, expected: Int) {
    val actual = longestSquareStreak(nums)
    assertEquals(expected, actual)
}
