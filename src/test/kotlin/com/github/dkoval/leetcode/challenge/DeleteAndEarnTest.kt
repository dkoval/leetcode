package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DeleteAndEarn.DeleteAndEarnDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteAndEarnTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 4, 2),
                6
            ),
            Arguments.of(
                intArrayOf(2, 2, 3, 3, 3, 4),
                9
            )
        )
    }

    @Nested
    inner class DeleteAndEarnDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should maximize the number of points`(nums: IntArray, expected: Int) {
            DeleteAndEarnDPTopDown().test(nums, expected)
        }
    }

    private fun DeleteAndEarn.test(nums: IntArray, expected: Int) {
        val actual = deleteAndEarn(nums)
        assertEquals(expected, actual)
    }
}