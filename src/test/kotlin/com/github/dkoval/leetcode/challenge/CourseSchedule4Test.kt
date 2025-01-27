package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CourseSchedule4.CourseSchedule4Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CourseSchedule4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                ),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                listOf(false, true)
            ),
            Arguments.of(
                2,
                emptyArray<IntArray>(),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                listOf(false, false)
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 0),
                    intArrayOf(2, 0)
                ),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2)
                ),
                listOf(true, true)
            ),
        )
    }

    @Nested
    inner class CourseSchedule4Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a boolean array answer, where answer(j) is the answer to the j-th query`(
            numCourses: Int,
            prerequisites: Array<IntArray>,
            queries: Array<IntArray>,
            expected: List<Boolean>
        ) {
            CourseSchedule4Rev1().test(numCourses, prerequisites, queries, expected)

        }
    }
}

private fun CourseSchedule4.test(
    numCourses: Int,
    prerequisites: Array<IntArray>,
    queries: Array<IntArray>,
    expected: List<Boolean>
) {
    val actual = checkIfPrerequisite(numCourses, prerequisites, queries)
    assertEquals(expected, actual)
}
