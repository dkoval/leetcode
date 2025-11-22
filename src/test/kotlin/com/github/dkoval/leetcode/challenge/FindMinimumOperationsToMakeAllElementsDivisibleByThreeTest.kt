package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMinimumOperationsToMakeAllElementsDivisibleByThree.FindMinimumOperationsToMakeAllElementsDivisibleByThreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMinimumOperationsToMakeAllElementsDivisibleByThreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                3
            ),
            Arguments.of(
                intArrayOf(3, 6, 9),
                0
            )
        )
    }

    @Nested
    inner class FindMinimumOperationsToMakeAllElementsDivisibleByThreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations to make all elements of nums divisible by 3`(
            nums: IntArray,
            expected: Int
        ) {
            FindMinimumOperationsToMakeAllElementsDivisibleByThreeRev1().test(nums, expected)
        }
    }
}

private fun FindMinimumOperationsToMakeAllElementsDivisibleByThree.test(nums: IntArray, expected: Int) {
    val actual = minimumOperations(nums)
    assertEquals(expected, actual)
}
