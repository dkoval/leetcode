package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivideArrayIntoArraysWithMaxDifference.DivideArrayIntoArraysWithMaxDifferenceRev1
import com.github.dkoval.leetcode.challenge.DivideArrayIntoArraysWithMaxDifference.DivideArrayIntoArraysWithMaxDifferenceRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DivideArrayIntoArraysWithMaxDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1),
                2,
                arrayOf(
                    intArrayOf(1, 1, 3),
                    intArrayOf(3, 4, 5),
                    intArrayOf(7, 8, 9)
                )
            ),
            Arguments.of(
                intArrayOf(1, 3, 3, 2, 7, 3),
                3,
                emptyArray<IntArray>()
            ),
            Arguments.of(
                intArrayOf(15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 5, 12, 12, 2, 13, 2, 2),
                2,
                emptyArray<IntArray>()
            )
        )
    }

    @Nested
    inner class DivideArrayIntoArraysWithMaxDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a 2D array containing all the arrays if it is impossible to satisfy the conditions`(
            nums: IntArray,
            k: Int,
            expected: Array<IntArray>
        ) {
            DivideArrayIntoArraysWithMaxDifferenceRev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class DivideArrayIntoArraysWithMaxDifferenceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a 2D array containing all the arrays if it is impossible to satisfy the conditions`(
            nums: IntArray,
            k: Int,
            expected: Array<IntArray>
        ) {
            DivideArrayIntoArraysWithMaxDifferenceRev2().test(nums, k, expected)
        }
    }
}

private fun DivideArrayIntoArraysWithMaxDifference.test(nums: IntArray, k: Int, expected: Array<IntArray>) {
    val actual = divideArray(nums, k)
    assertArrayEquals(expected, actual)
}
