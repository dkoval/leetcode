package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfGoodPairs.NumberOfGoodPairsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfGoodPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 1, 1, 3),
                4
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1),
                6
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                0
            )
        )
    }

    @Nested
    inner class NumberOfGoodPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of good pairs`(nums: IntArray, expected: Int) {
            NumberOfGoodPairsRev1().test(nums, expected)
        }
    }
}

private fun NumberOfGoodPairs.test(nums: IntArray, expected: Int) {
    val actual = numIdenticalPairs(nums)
    assertEquals(expected, actual)
}
