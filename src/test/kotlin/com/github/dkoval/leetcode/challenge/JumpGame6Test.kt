package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.JumpGame6.JumpGame6TTEOnLargeInput
import com.github.dkoval.leetcode.challenge.JumpGame6.JumpGame6UsingSlidingWindow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class JumpGame6Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, -1, -2, 4, -7, 3),
                2,
                7
            ),
            Arguments.of(
                intArrayOf(10, -5, -2, 4, 0, 3),
                3,
                17
            ),
            Arguments.of(
                intArrayOf(1, -5, -20, 4, -1, 3, -6, -3),
                2,
                0
            ),
            Arguments.of(
                intArrayOf(40, 30, -100, -100, -10, -7, -3, -3),
                // [40, 70, -30, -30, -40, -37, -40, -40] - correct
                // [40, 70, -30, -30, -40, -47, -43, -46] - wrong
                2,
                -40
            )
        )
    }

    @Nested
    inner class JumpGame6TTEOnLargeInputTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score`(nums: IntArray, k: Int, expected: Int) {
            JumpGame6TTEOnLargeInput().test(nums, k, expected)
        }
    }

    @Nested
    inner class JumpGame6UsingSlidingWindowTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score`(nums: IntArray, k: Int, expected: Int) {
            JumpGame6UsingSlidingWindow().test(nums, k, expected)
        }
    }

    private fun JumpGame6.test(nums: IntArray, k: Int, expected: Int) {
        val actual = maxResult(nums, k)
        assertEquals(expected, actual)
    }
}