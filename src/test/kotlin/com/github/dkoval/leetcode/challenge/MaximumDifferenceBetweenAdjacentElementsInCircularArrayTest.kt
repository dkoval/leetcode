package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumDifferenceBetweenAdjacentElementsInCircularArray.MaximumDifferenceBetweenAdjacentElementsInCircularArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDifferenceBetweenAdjacentElementsInCircularArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 4),
                3
            ),
            Arguments.of(
                intArrayOf(-5, -10, -5),
                5
            )
        )
    }

    @Nested
    inner class MaximumDifferenceBetweenAdjacentElementsInCircularArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum difference between adjacent elements in a circular array`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumDifferenceBetweenAdjacentElementsInCircularArrayRev1().test(nums, expected)
        }
    }
}

private fun MaximumDifferenceBetweenAdjacentElementsInCircularArray.test(nums: IntArray, expected: Int) {
    val actual = maxAdjacentDistance(nums)
    assertEquals(expected, actual)
}