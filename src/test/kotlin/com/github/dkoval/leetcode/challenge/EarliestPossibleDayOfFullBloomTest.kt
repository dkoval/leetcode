package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.EarliestPossibleDayOfFullBloom.EarliestPossibleDayOfFullBloomRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class EarliestPossibleDayOfFullBloomTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 4, 3),
                intArrayOf(2, 3, 1),
                9
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 2),
                intArrayOf(2, 1, 2, 1),
                9
            ),
            Arguments.of(
                intArrayOf(1),
                intArrayOf(1),
                2
            ),
            Arguments.of(
                intArrayOf(27, 5, 24, 17, 27, 4, 23, 16, 6, 26, 13, 17, 21, 3, 9, 10, 28, 26, 4, 10, 28, 2),
                intArrayOf(26, 9, 14, 17, 6, 14, 23, 24, 11, 6, 27, 14, 13, 1, 15, 5, 12, 15, 23, 27, 28, 12),
                348
            )
        )
    }

    @Nested
    inner class EarliestPossibleDayOfFullBloomRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the earliest possible day where all seeds are blooming`(
            plantTime: IntArray,
            growTime: IntArray,
            expected: Int
        ) {
            EarliestPossibleDayOfFullBloomRev1().test(plantTime, growTime, expected)
        }
    }

    private fun EarliestPossibleDayOfFullBloom.test(plantTime: IntArray, growTime: IntArray, expected: Int) {
        val actual = earliestFullBloom(plantTime, growTime)
        assertEquals(expected, actual)
    }
}