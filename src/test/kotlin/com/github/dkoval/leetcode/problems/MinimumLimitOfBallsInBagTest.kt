package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumLimitOfBallsInBag.MinimumLimitOfBallsInBagUsingBinarySearchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumLimitOfBallsInBagTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(9),
                2,
                3
            ),
            Arguments.of(
                intArrayOf(2,4,8,2),
                4,
                2
            ),
            Arguments.of(
                intArrayOf(7, 17),
                2,
                7
            )
        )
    }

    @Nested
    inner class MinimumLimitOfBallsInBagUsingBinarySearchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible penalty after performing the operations`(
            nums: IntArray,
            maxOperations: Int,
            expected: Int
        ) {
            MinimumLimitOfBallsInBagUsingBinarySearchRev1().test(nums, maxOperations, expected)
        }
    }

    private fun MinimumLimitOfBallsInBag.test(nums: IntArray, maxOperations: Int, expected: Int) {
        val actual = minimumSize(nums, maxOperations)
        assertEquals(expected, actual)
    }
}