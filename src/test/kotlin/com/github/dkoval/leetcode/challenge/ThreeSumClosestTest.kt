package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ThreeSumClosest.ThreeSumClosestRev1
import com.github.dkoval.leetcode.challenge.ThreeSumClosest.ThreeSumClosestRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ThreeSumClosestTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-1, 2, 1, -4),
                1,
                2
            ),
            Arguments.of(
                intArrayOf(0, 2, 1, -3),
                1,
                0
            ),
            Arguments.of(
                intArrayOf(1, 1, -1, -1, 3),
                -1,
                -1
            )
        )
    }

    @Nested
    inner class ThreeSumClosestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find three integers in nums such that the sum is closest to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            ThreeSumClosestRev1().test(nums, target, expected)
        }
    }

    @Nested
    inner class ThreeSumClosestRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find three integers in nums such that the sum is closest to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            ThreeSumClosestRev2().test(nums, target, expected)
        }
    }

    private fun ThreeSumClosest.test(nums: IntArray, target: Int, expected: Int) {
        val actual = threeSumClosest(nums, target)
        assertEquals(expected, actual)
    }
}