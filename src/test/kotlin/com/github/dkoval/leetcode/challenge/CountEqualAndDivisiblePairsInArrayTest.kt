package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountEqualAndDivisiblePairsInArray.CountEqualAndDivisiblePairsInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountEqualAndDivisiblePairsInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1, 2, 2, 2, 1, 3),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                1,
                0
            )
        )
    }

    @Nested
    inner class CountEqualAndDivisiblePairsInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of pairs (i, j)`(nums: IntArray, k: Int, expected: Int) {
            CountEqualAndDivisiblePairsInArrayRev1().test(nums, k, expected)
        }
    }
}

private fun CountEqualAndDivisiblePairsInArray.test(nums: IntArray, k: Int, expected: Int) {
    val actual = countPairs(nums, k)
    assertEquals(expected, actual)
}
