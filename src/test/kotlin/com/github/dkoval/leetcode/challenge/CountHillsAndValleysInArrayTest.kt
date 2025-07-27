package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountHillsAndValleysInArray.CountHillsAndValleysInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountHillsAndValleysInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 4, 1, 1, 6, 5),
                3
            ),
            Arguments.of(
                intArrayOf(6, 6, 5, 5, 4, 1),
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                0
            ),
            Arguments.of(
                intArrayOf(1, 3, 2),
                1
            )
        )
    }

    @Nested
    inner class CountHillsAndValleysInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of hills and valleys in the given array`(nums: IntArray, expected: Int) {
            CountHillsAndValleysInArrayRev1().test(nums, expected)
        }
    }
}

private fun CountHillsAndValleysInArray.test(nums: IntArray, expected: Int) {
    val actual = countHillValley(nums)
    assertEquals(expected, actual)
}
