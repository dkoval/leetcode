package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HouseRobberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 1),
                // Rob house 1 (money = 1) and then rob house 3 (money = 3).
                // Total amount you can rob = 1 + 3 = 4.
                4
            ),
            Arguments.of(
                intArrayOf(2, 7, 9, 3, 1),
                // Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                // Total amount you can rob = 2 + 9 + 1 = 12.
                12
            )
        )
    }

    @Nested
    inner class HouseRobberDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the maximum amount of money you can rob tonight without alerting the police`(
            nums: IntArray,
            expected: Int
        ) {
            HouseRobberDPTopDown.test(nums, expected)
        }
    }

    @Nested
    inner class HouseRobberDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the maximum amount of money you can rob tonight without alerting the police`(
            nums: IntArray,
            expected: Int
        ) {
            HouseRobberDPBottomUp.test(nums, expected)
        }
    }

    @Nested
    inner class HouseRobberDPBottomUpSpaceOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the maximum amount of money you can rob tonight without alerting the police`(
            nums: IntArray,
            expected: Int
        ) {
            HouseRobberDPBottomUpSpaceOptimized.test(nums, expected)
        }
    }

    private fun HouseRobber.test(nums: IntArray, expected: Int) {
        val actual = rob(nums)
        assertEquals(expected, actual)
    }
}