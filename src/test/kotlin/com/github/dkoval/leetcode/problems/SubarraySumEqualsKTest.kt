package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SubarraySumEqualsKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 1),
                2,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                3,
                2
            ),
            Arguments.of(
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                0,
                55
            )
        )
    }

    @Nested
    inner class SubarraySumEqualsKBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the total number of continuous subarrays whose sum equals to k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarraySumEqualsKBruteForce.test(nums, k, expected)
        }
    }

    @Nested
    inner class SubarraySumEqualsKUsingHashMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the total number of continuous subarrays whose sum equals to k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SubarraySumEqualsKUsingHashMap.test(nums, k, expected)
        }
    }

    private fun SubarraySumEqualsK.test(nums: IntArray, k: Int, expected: Int) {
        val actual = subarraySum(nums, k)
        assertEquals(expected, actual)
    }
}