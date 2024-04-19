package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MostProfitAssigningWork.MostProfitAssigningWorkUsingSortingByDifficulty
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MostProfitAssigningWorkTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 4, 6, 8, 10),
                intArrayOf(10, 20, 30, 40, 50),
                intArrayOf(4, 5, 6, 7),
                100
            ),
            Arguments.of(
                intArrayOf(85, 47, 57),
                intArrayOf(24, 66, 99),
                intArrayOf(40, 25, 25),
                0
            )
        )
    }

    @Nested
    inner class MostProfitAssigningWorkUsingSortingByDifficultyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum profit we can achieve after assigning the workers to the jobs`(
            difficulty: IntArray,
            profit: IntArray,
            worker: IntArray,
            expected: Int
        ) {
            MostProfitAssigningWorkUsingSortingByDifficulty().test(difficulty, profit, worker, expected)
        }
    }
}

private fun MostProfitAssigningWork.test(difficulty: IntArray, profit: IntArray, worker: IntArray, expected: Int) {
    val actual = maxProfitAssignment(difficulty, profit, worker)
    assertEquals(expected, actual)
}
