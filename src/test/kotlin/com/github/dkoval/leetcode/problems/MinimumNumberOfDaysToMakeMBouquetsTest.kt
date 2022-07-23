package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumNumberOfDaysToMakeMBouquets.MinimumNumberOfDaysToMakeMBouquetsUsingBinarySearchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfDaysToMakeMBouquetsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 10, 3, 10, 2),
                3,
                1,
                3
            ),
            Arguments.of(
                intArrayOf(1, 10, 3, 10, 2),
                3,
                2,
                -1
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 12, 7, 7),
                2,
                3,
                12
            )
        )
    }

    @Nested
    inner class MinimumNumberOfDaysToMakeMBouquetsUsingBinarySearchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of days you need to wait to be able to make m bouquets from the garden`(
            bloomDay: IntArray,
            m: Int,
            k: Int,
            expected: Int
        ) {
            MinimumNumberOfDaysToMakeMBouquetsUsingBinarySearchRev1()
                .test(bloomDay, m, k, expected)
        }
    }

    private fun MinimumNumberOfDaysToMakeMBouquets.test(bloomDay: IntArray, m: Int, k: Int, expected: Int) {
        val actual = minDays(bloomDay, m, k)
        assertEquals(expected, actual)
    }
}