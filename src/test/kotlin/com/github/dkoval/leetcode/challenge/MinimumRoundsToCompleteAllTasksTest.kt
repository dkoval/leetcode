package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumRoundsToCompleteAllTasks.MinimumRoundsToCompleteAllTasksRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumRoundsToCompleteAllTasksTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 2, 3, 3, 2, 4, 4, 4, 4, 4),
                4
            ),
            Arguments.of(
                intArrayOf(2, 3, 3),
                -1
            ),
            Arguments.of(
                intArrayOf(66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61),
                20
            )
        )
    }

    @Nested
    inner class MinimumRoundsToCompleteAllTasksRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks`(
            tasks: IntArray,
            expected: Int
        ) {
            MinimumRoundsToCompleteAllTasksRev1().test(tasks, expected)
        }
    }

    private fun MinimumRoundsToCompleteAllTasks.test(tasks: IntArray, expected: Int) {
        val actual = minimumRounds(tasks)
        assertEquals(expected, actual)
    }
}