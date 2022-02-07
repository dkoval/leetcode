package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.SolvingQuestionsWithBrainpower.SolvingQuestionsWithBrainpowerDPBottomUp
import com.github.dkoval.leetcode.problems.SolvingQuestionsWithBrainpower.SolvingQuestionsWithBrainpowerDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SolvingQuestionsWithBrainpowerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(4, 3),
                    intArrayOf(4, 4),
                    intArrayOf(2, 5)
                ),
                5,
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                    intArrayOf(4, 4),
                    intArrayOf(5, 5)
                ),
                7
            )
        )
    }

    @Nested
    inner class SolvingQuestionsWithBrainpowerDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum points you can earn for the exam`(questions: Array<IntArray>, expected: Long) {
            SolvingQuestionsWithBrainpowerDPTopDown().test(questions, expected)
        }
    }

    @Nested
    inner class SolvingQuestionsWithBrainpowerDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum points you can earn for the exam`(questions: Array<IntArray>, expected: Long) {
            SolvingQuestionsWithBrainpowerDPBottomUp().test(questions, expected)
        }
    }

    private fun SolvingQuestionsWithBrainpower.test(questions: Array<IntArray>, expected: Long) {
        val actual = mostPoints(questions)
        assertEquals(expected, actual)
    }
}