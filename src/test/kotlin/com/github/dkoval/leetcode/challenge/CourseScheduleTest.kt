package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CourseScheduleTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                ),
                true
            ),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should detect if it is possible for you to finish all courses, given a list of prerequisite pairs`(
        numCourses: Int,
        prerequisites: Array<IntArray>,
        expected: Boolean
    ) {
        val actual = CourseSchedule.canFinish(numCourses, prerequisites)
        assertEquals(expected, actual)
    }
}