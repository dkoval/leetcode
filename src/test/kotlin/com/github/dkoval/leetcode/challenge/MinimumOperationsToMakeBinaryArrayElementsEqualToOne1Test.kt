package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumOperationsToMakeBinaryArrayElementsEqualToOne1.MinimumOperationsToMakeBinaryArrayElementsEqualToOne1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumOperationsToMakeBinaryArrayElementsEqualToOne1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 1, 1, 0, 0),
                3
            ),
            Arguments.of(
                intArrayOf(0, 1, 1, 1),
                -1
            ),
            Arguments.of(
                intArrayOf(1, 0, 0, 1, 1, 1, 0, 1, 1, 1),
                3
            )
        )
    }

    @Nested
    inner class MinimumOperationsToMakeBinaryArrayElementsEqualToOne1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations needed to make the binary array elements equal to 1`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumOperationsToMakeBinaryArrayElementsEqualToOne1Rev1().test(nums, expected)
        }
    }
}

private fun MinimumOperationsToMakeBinaryArrayElementsEqualToOne1.test(nums: IntArray, expected: Int) {
    val actual = minOperations(nums)
    assertEquals(expected, actual)
}
