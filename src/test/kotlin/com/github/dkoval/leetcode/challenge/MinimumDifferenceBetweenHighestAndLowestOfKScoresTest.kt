package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumDifferenceBetweenHighestAndLowestOfKScores.MinimumDifferenceBetweenHighestAndLowestOfKScoresRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDifferenceBetweenHighestAndLowestOfKScoresTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(90),
                1,
                0
            ),
            Arguments.of(
                intArrayOf(9, 4, 1, 7),
                2,
                2
            )
        )
    }

    @Nested
    inner class MinimumDifferenceBetweenHighestAndLowestOfKScoresRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible difference`(scores: IntArray, k: Int, expected: Int) =
            MinimumDifferenceBetweenHighestAndLowestOfKScoresRev1().test(scores, k, expected)
    }
}

private fun MinimumDifferenceBetweenHighestAndLowestOfKScoresRev1.test(scores: IntArray, k: Int, expected: Int) {
    val actual = minimumDifference(scores, k)
    assertEquals(expected, actual)
}
