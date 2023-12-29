package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumDifficultyOfJobSchedule.MinimumDifficultyOfJobScheduleRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumDifficultyOfJobScheduleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(6, 5, 4, 3, 2, 1),
                2,
                7
            ),
            Arguments.of(
                intArrayOf(9, 9, 9),
                4,
                -1
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(7, 1, 7, 1, 7, 1),
                3,
                15
            )
        )
    }

    @Nested
    inner class MinimumDifficultyOfJobScheduleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum difficulty of a job schedule`(jobDifficulty: IntArray, d: Int, expected: Int) {
            MinimumDifficultyOfJobScheduleRev1().test(jobDifficulty, d, expected)
        }
    }
}

private fun MinimumDifficultyOfJobSchedule.test(jobDifficulty: IntArray, d: Int, expected: Int) {
    val actual = minDifficulty(jobDifficulty, d)
    assertEquals(expected, actual)
}
