package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSubsequencesThatSatisfyGivenSumCondition.NumberOfSubsequencesThatSatisfyGivenSumConditionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfSubsequencesThatSatisfyGivenSumConditionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 5, 6, 7),
                9,
                4
            ),
            Arguments.of(
                intArrayOf(3, 3, 6, 8),
                10,
                6
            ),
            Arguments.of(
                intArrayOf(2, 3, 3, 4, 6, 7),
                12,
                61
            ),
            Arguments.of(
                intArrayOf(14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14),
                22,
                272187084
            )
        )
    }

    @Nested
    inner class NumberOfSubsequencesThatSatisfyGivenSumConditionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            NumberOfSubsequencesThatSatisfyGivenSumConditionRev1().test(nums, target, expected)
        }
    }
}

private fun NumberOfSubsequencesThatSatisfyGivenSumCondition.test(nums: IntArray, target: Int, expected: Int) {
    val actual = numSubseq(nums, target)
    assertEquals(expected, actual)
}
