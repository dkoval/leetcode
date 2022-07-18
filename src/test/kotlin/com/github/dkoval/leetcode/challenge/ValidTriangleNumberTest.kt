package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ValidTriangleNumber.ValidTriangleNumberRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidTriangleNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 2, 3, 4),
                3
            ),
            Arguments.of(
                intArrayOf(4, 2, 3, 4),
                4
            )
        )
    }

    @Nested
    inner class ValidTriangleNumberRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of triplets chosen from the array that can make triangles`(
            nums: IntArray,
            expected: Int
        ) {
            ValidTriangleNumberRev1().test(nums, expected)
        }
    }

    private fun ValidTriangleNumber.test(nums: IntArray, expected: Int) {
        val actual = triangleNumber(nums)
        assertEquals(expected, actual)
    }
}