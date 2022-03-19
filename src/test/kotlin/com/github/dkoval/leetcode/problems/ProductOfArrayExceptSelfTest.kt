package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ProductOfArrayExceptSelf.ProductOfArrayExceptSelfUsingExtraSpace
import com.github.dkoval.leetcode.problems.ProductOfArrayExceptSelf.ProductOfArrayExceptSelfWithoutExtraSpace
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ProductOfArrayExceptSelfTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(24, 12, 8, 6)
            ),
            Arguments.of(
                intArrayOf(-1, 1, 0, -3, 3),
                intArrayOf(0, 0, 9, 0, 0)
            )
        )
    }

    @Nested
    inner class ProductOfArrayExceptSelfUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array answer such that answer(i) is equal to the product of all the elements of nums except nums(i)`(
            nums: IntArray,
            expected: IntArray
        ) {
            ProductOfArrayExceptSelfUsingExtraSpace().test(nums, expected)
        }
    }

    @Nested
    inner class ProductOfArrayExceptSelfWithoutExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array answer such that answer(i) is equal to the product of all the elements of nums except nums(i)`(
            nums: IntArray,
            expected: IntArray
        ) {
            ProductOfArrayExceptSelfWithoutExtraSpace().test(nums, expected)
        }
    }

    private fun ProductOfArrayExceptSelf.test(nums: IntArray, expected: IntArray) {
        val actual = productExceptSelf(nums)
        assertArrayEquals(expected, actual)
    }
}