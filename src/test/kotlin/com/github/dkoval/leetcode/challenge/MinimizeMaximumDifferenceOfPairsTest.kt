package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimizeMaximumDifferenceOfPairs.MinimizeMaximumDifferenceOfPairsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimizeMaximumDifferenceOfPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 1, 2, 7, 1, 3),
                2,
                1
            ),
            Arguments.of(
                intArrayOf(4, 2, 1, 2),
                1,
                0
            )
        )
    }

    @Nested
    inner class MinimizeMaximumDifferenceOfPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum maximum difference among all p pairs`(
            nums: IntArray,
            p: Int,
            expected: Int
        ) {
            MinimizeMaximumDifferenceOfPairsRev1().test(nums, p, expected)
        }
    }
}

private fun MinimizeMaximumDifferenceOfPairs.test(nums: IntArray, p: Int, expected: Int) {
    val actual = minimizeMax(nums, p)
    assertEquals(expected, actual)
}
