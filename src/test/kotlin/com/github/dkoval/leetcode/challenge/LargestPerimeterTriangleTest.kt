package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestPerimeterTriangle.LargestPerimeterTriangleRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestPerimeterTriangleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 2),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 1),
                0
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `should return the largest perimeter of a triangle with a non-zero area`(nums: IntArray, expected: Int) {
        LargestPerimeterTriangleRev1().test(nums, expected)
    }

    private fun LargestPerimeterTriangle.test(nums: IntArray, expected: Int) {
        val actual = largestPerimeter(nums)
        assertEquals(expected, actual)
    }
}