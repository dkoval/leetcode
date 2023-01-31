package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BestTeamWithNoConflicts.BestTeamWithNoConflictsDPBottomUp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class BestTeamWithNoConflictsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 5, 10, 15),
                intArrayOf(1, 2, 3, 4, 5),
                34
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 5),
                intArrayOf(2, 1, 2, 1),
                16
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 5),
                intArrayOf(8, 9, 10, 1),
                6
            ),
            Arguments.of(
                intArrayOf(319776, 611683, 835240, 602298, 430007, 574, 142444, 858606, 734364, 896074),
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                5431066
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                intArrayOf(811, 364, 124, 873, 790, 656, 581, 446, 885, 134),
                10
            )
        )
    }

    @Nested
    inner class BestTeamWithNoConflictsDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the highest overall score of all possible basketball teams`(scores: IntArray, ages: IntArray, expected: Int) {
            BestTeamWithNoConflictsDPBottomUp().test(scores, ages, expected)
        }
    }
}

private fun BestTeamWithNoConflicts.test(scores: IntArray, ages: IntArray, expected: Int) {
    val actual = bestTeamScore(scores, ages)
    assertEquals(expected, actual)
}
