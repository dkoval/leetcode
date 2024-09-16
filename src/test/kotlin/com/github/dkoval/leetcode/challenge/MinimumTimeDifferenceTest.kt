package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeDifference.MinimumTimeDifferenceRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf("23:59", "00:00"),
                1
            ),
            Arguments.of(
                listOf("00:00", "23:59", "00:00"),
                0
            ),
            Arguments.of(
                listOf("01:01", "02:01", "03:00"),
                59
            ),
            Arguments.of(
                listOf("12:12", "12:13", "00:12", "00:13"),
                1
            )
        )
    }

    @Nested
    inner class MinimumTimeDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum minutes difference between any two time-points in the list`(
            timePoints: List<String>,
            expected: Int
        ) {
            MinimumTimeDifferenceRev1().test(timePoints, expected)
        }
    }
}

private fun MinimumTimeDifference.test(timePoints: List<String>, expected: Int) {
    val actual = findMinDifference(timePoints)
    assertEquals(expected, actual)
}
