package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.interview.array.JumpGame.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class JumpGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 1, 1, 4),
                true
            ),
            Arguments.of(
                intArrayOf(3, 2, 1, 0, 4),
                false
            )
        )
    }

    @Nested
    inner class JumpGameRecursiveTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can reach the last index`(nums: IntArray, expected: Boolean) {
            JumpGameRecursiveTLE().test(nums, expected)
        }
    }

    @Nested
    inner class JumpGameDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can reach the last index`(nums: IntArray, expected: Boolean) {
            JumpGameDPTopDown().test(nums, expected)
        }
    }

    @Nested
    inner class JumpGameDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can reach the last index`(nums: IntArray, expected: Boolean) {
            JumpGameDPBottomUp().test(nums, expected)
        }
    }

    private fun JumpGame.test(nums: IntArray, expected: Boolean) {
        val actual = canJump(nums)
        assertEquals(expected, actual)
    }
}