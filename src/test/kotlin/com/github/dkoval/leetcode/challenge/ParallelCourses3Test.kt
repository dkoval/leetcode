package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ParallelCourses3.ParallelCourses3Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ParallelCourses3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                ),
                intArrayOf(3, 2, 5),
                8
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(1, 5),
                    intArrayOf(2, 5),
                    intArrayOf(3, 5),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5)
                ),
                intArrayOf(1, 2, 3, 4, 5),
                12
            )
        )
    }

    @Nested
    inner class ParallelCourses3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of months needed to complete all the courses`(
            n: Int,
            relations: Array<IntArray>,
            time: IntArray,
            expected: Int
        ) {
            ParallelCourses3Rev1().test(n, relations, time, expected)
        }
    }
}

private fun ParallelCourses3.test(n: Int, relations: Array<IntArray>, time: IntArray, expected: Int) {
    val actual = minimumTime(n, relations, time)
    assertEquals(expected, actual)
}
