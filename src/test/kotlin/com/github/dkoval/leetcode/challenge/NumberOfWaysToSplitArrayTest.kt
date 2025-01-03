package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysToSplitArray.NumberOfWaysToSplitArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysToSplitArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 4, -8, 7),
                2
            ),
            Arguments.of(
                intArrayOf(2, 3, 1, 0),
                2
            ),
            Arguments.of(
                intArrayOf(6, -1, 9),
                0
            )
        )
    }

    @Nested
    inner class NumberOfWaysToSplitArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of valid splits in nums`(nums: IntArray, expected: Int) {
            NumberOfWaysToSplitArrayRev1().test(nums, expected)
        }
    }
}

private fun NumberOfWaysToSplitArray.test(nums: IntArray, expected: Int) {
    val actual = waysToSplitArray(nums)
    assertEquals(expected, actual)
}
