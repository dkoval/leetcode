package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.JumpGame2.JumpGame2Rev1
import com.github.dkoval.leetcode.challenge.JumpGame2.JumpGame2Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class JumpGame2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 1, 1, 4),
                2
            ),
            Arguments.of(
                intArrayOf(2, 3, 0, 1, 4),
                2
            ),
            Arguments.of(
                intArrayOf(2, 1),
                1
            )
        )
    }

    @Nested
    inner class JumpGame2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of jumps required to reach the last index`(nums: IntArray, expected: Int) {
            JumpGame2Rev1().test(nums, expected)
        }
    }

    @Nested
    inner class JumpGame2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of jumps required to reach the last index`(nums: IntArray, expected: Int) {
            JumpGame2Rev2().test(nums, expected)
        }
    }
}

private fun JumpGame2.test(nums: IntArray, expected: Int) {
    val actual = jump(nums)
    assertEquals(expected, actual)
}
