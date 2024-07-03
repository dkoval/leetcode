package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 3, 2, 4),
                0
            ),
            Arguments.of(
                intArrayOf(1, 5, 0, 10, 14),
                1
            ),
            Arguments.of(
                intArrayOf(3, 100, 20),
                0
            )
        )
    }

    @Nested
    inner class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the min difference between the largest and smallest value of nums after performing at most 3 moves`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesRev1().test(nums, expected)
        }
    }
}

private fun MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.test(nums: IntArray, expected: Int) {
    val actual = minDifference(nums)
    assertEquals(expected, actual)
}
