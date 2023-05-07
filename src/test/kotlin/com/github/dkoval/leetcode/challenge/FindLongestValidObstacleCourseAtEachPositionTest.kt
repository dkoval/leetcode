package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLongestValidObstacleCourseAtEachPosition.FindLongestValidObstacleCourseAtEachPositionRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLongestValidObstacleCourseAtEachPositionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 2),
                intArrayOf(1, 2, 3, 3)
            ),
            Arguments.of(
                intArrayOf(2, 2, 1),
                intArrayOf(1, 2, 1)
            ),
            Arguments.of(
                intArrayOf(3, 1, 5, 6, 4, 2),
                intArrayOf(1, 1, 2, 3, 2, 2)
            ),
            Arguments.of(
                intArrayOf(5, 1, 5, 5, 1, 3, 4, 5, 1, 4),
                intArrayOf(1, 1, 2, 3, 2, 3, 4, 5, 3, 5)
            )
        )
    }

    @Nested
    inner class FindLongestValidObstacleCourseAtEachPositionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array ans of length n, where ans(i) is the length of the longest obstacle course`(
            obstacles: IntArray,
            expected: IntArray
        ) {
            FindLongestValidObstacleCourseAtEachPositionRev1().test(obstacles, expected)
        }
    }
}

private fun FindLongestValidObstacleCourseAtEachPosition.test(obstacles: IntArray, expected: IntArray) {
    val actual = longestObstacleCourseAtEachPosition(obstacles)
    assertArrayEquals(expected, actual)
}
