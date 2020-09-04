package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ContainsDuplicate3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 1), 3, 0, true
            ),
            Arguments.of(
                intArrayOf(1, 0, 1, 1), 1, 2, true
            ),
            Arguments.of(
                intArrayOf(1, 5, 9, 1, 5, 9), 2, 3, false
            ),
            Arguments.of(
                intArrayOf(-1, 2147483647),
                1,
                2147483647,
                false
            ),
            Arguments.of(
                intArrayOf(0),
                0,
                0,
                false
            ),
            Arguments.of(
                intArrayOf(2, 2),
                3,
                0,
                true
            )
        )
    }

    @Nested
    inner class ContainsDuplicate3BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should test containsNearbyAlmostDuplicate() method`(nums: IntArray, k: Int, t: Int, expected: Boolean) {
            ContainsDuplicate3BruteForce.test(nums, k, t, expected)
        }
    }

    @Nested
    inner class ContainsDuplicate3StraightforwardTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should test containsNearbyAlmostDuplicate() method`(nums: IntArray, k: Int, t: Int, expected: Boolean) {
            ContainsDuplicate3Straightforward.test(nums, k, t, expected)
        }
    }

    @Nested
    inner class ContainsDuplicate3UsingTreeSetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should test containsNearbyAlmostDuplicate() method`(nums: IntArray, k: Int, t: Int, expected: Boolean) {
            ContainsDuplicate3UsingTreeSet.test(nums, k, t, expected)
        }
    }

    private fun ContainsDuplicate3.test(nums: IntArray, k: Int, t: Int, expected: Boolean) {
        val actual = containsNearbyAlmostDuplicate(nums, k, t)
        assertEquals(expected, actual)
    }
}