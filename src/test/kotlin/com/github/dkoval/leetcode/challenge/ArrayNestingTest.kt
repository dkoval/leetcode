package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ArrayNesting.ArrayNestingUsingConstantSpace
import com.github.dkoval.leetcode.challenge.ArrayNesting.ArrayNestingUsingExtraSpace
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ArrayNestingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 4, 0, 3, 1, 6, 2),
                4
            ),
            Arguments.of(
                intArrayOf(0, 1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(0),
                1
            )
        )
    }

    @Nested
    inner class ArrayNestingUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest length of a set s(k)`(nums: IntArray, expected: Int) {
            ArrayNestingUsingExtraSpace().test(nums, expected)
        }
    }

    @Nested
    inner class ArrayNestingUsingConstantSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest length of a set s(k)`(nums: IntArray, expected: Int) {
            ArrayNestingUsingConstantSpace().test(nums, expected)
        }
    }

    private fun ArrayNesting.test(nums: IntArray, expected: Int) {
        val actual = arrayNesting(nums)
        assertEquals(expected, actual)
    }
}