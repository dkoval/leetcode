package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfMaximumBitwiseORSubsets.CountNumberOfMaximumBitwiseORSubsetsRev1
import com.github.dkoval.leetcode.challenge.CountNumberOfMaximumBitwiseORSubsets.CountNumberOfMaximumBitwiseORSubsetsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfMaximumBitwiseORSubsetsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1),
                2
            ),
            Arguments.of(
                intArrayOf(2, 2, 2),
                7
            ),
            Arguments.of(
                intArrayOf(3, 2, 1, 5),
                6
            )
        )
    }

    @Nested
    inner class CountNumberOfMaximumBitwiseORSubsetsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different non-empty subsets with the maximum bitwise OR`(
            nums: IntArray,
            expected: Int
        ) {
            CountNumberOfMaximumBitwiseORSubsetsRev1().test(nums, expected)
        }
    }

    @Nested
    inner class CountNumberOfMaximumBitwiseORSubsetsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different non-empty subsets with the maximum bitwise OR`(
            nums: IntArray,
            expected: Int
        ) {
            CountNumberOfMaximumBitwiseORSubsetsRev2().test(nums, expected)
        }
    }
}

private fun CountNumberOfMaximumBitwiseORSubsets.test(nums: IntArray, expected: Int) {
    val actual = countMaxOrSubsets(nums)
    assertEquals(expected, actual)
}
