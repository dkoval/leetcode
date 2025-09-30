package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindTriangularSumOfArray.FindTriangularSumOfArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindTriangularSumOfArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                8
            ),
            Arguments.of(
                intArrayOf(5),
                5
            )
        )
    }

    @Nested
    inner class FindTriangularSumOfArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find triangular sum of array`(nums: IntArray, expected: Int) {
            FindTriangularSumOfArrayRev1().test(nums, expected)
        }
    }
}

private fun FindTriangularSumOfArray.test(nums: IntArray, expected: Int) {
    val actual = triangularSum(nums)
    assertEquals(expected, actual)
}
