package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CourseSchedule3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    intArrayOf(100, 200),
                    intArrayOf(200, 1300),
                    intArrayOf(1000, 1250),
                    intArrayOf(2000, 3200)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(4, 3)
                ),
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum number of courses`(courses: Array<IntArray>, expected: Int) {
        val actual = CourseSchedule3().scheduleCourse(courses)
        assertEquals(expected, actual)
    }
}