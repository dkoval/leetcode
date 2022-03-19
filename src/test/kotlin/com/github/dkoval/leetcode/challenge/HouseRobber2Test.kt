package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.HouseRobber2.HouseRobber2DPArray
import com.github.dkoval.leetcode.challenge.HouseRobber2.HouseRobber2DPSpaceOptimized
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HouseRobber2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                0
            ),
            Arguments.of(
                intArrayOf(3, 5),
                5
            ),
            Arguments.of(
                intArrayOf(2, 3, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 1),
                4
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 1),
                4
            ),
            Arguments.of(
                intArrayOf(200, 3, 140, 20, 10),
                340
            )
        )
    }

    @Nested
    inner class HouseRobber2DPArrayTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of money you can rob tonight without alerting the police`(
            nums: IntArray,
            expected: Int
        ) {
            HouseRobber2DPArray().test(nums, expected)
        }
    }

    @Nested
    inner class HouseRobber2DPSpaceOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of money you can rob tonight without alerting the police`(
            nums: IntArray,
            expected: Int
        ) {
            HouseRobber2DPSpaceOptimized().test(nums, expected)
        }
    }

    private fun HouseRobber2.test(nums: IntArray, expected: Int) {
        val actual = rob(nums)
        assertEquals(expected, actual)
    }
}