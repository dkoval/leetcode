package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KDiffPairsInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1, 4, 1, 5),
                2,
                // There are two 2-diff pairs in the array, (1, 3) and (3, 5).
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                // There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
                1
            ),
            Arguments.of(
                intArrayOf(1, 3, 1, 5, 4),
                0,
                // There is one 0-diff pair in the array, (1, 1).
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, 4, 4, 3, 3, 0, 9, 2, 3),
                3,
                2
            ),
            Arguments.of(
                intArrayOf(-1, -2, -3),
                1,
                2
            )
        )
    }

    @Nested
    inner class KDiffPairsInArrayBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique k-diff pairs in the array`(nums: IntArray, k: Int, expected: Int) {
            KDiffPairsInArrayBruteForce.test(nums, k, expected)
        }
    }

    @Nested
    inner class KDiffPairsInArrayInNLogNTimeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique k-diff pairs in the array`(nums: IntArray, k: Int, expected: Int) {
            KDiffPairsInArrayInNLogNTime.test(nums, k, expected)
        }
    }

    @Nested
    inner class KDiffPairsInArrayInNLogNTimeJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique k-diff pairs in the array`(nums: IntArray, k: Int, expected: Int) {
            KDiffPairsInArrayInNLogNTimeJava().test(nums, k, expected)
        }
    }

    private fun KDiffPairsInArray.test(nums: IntArray, k: Int, expected: Int) {
        val actual = findPairs(nums, k)
        assertEquals(expected, actual)
    }
}