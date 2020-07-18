package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CourseSchedule2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                ),
                intArrayOf(0, 1)
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2)
                ),
                intArrayOf(0, 2, 1, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the ordering of courses you should take to finish all courses`(
        numCourses: Int,
        prerequisites: Array<IntArray>,
        expected: IntArray
    ) {
        val actual = CourseSchedule2.findOrder(numCourses, prerequisites)
        assertArrayEquals(expected, actual)
    }
}