package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTotalDistanceTraveled.MinimumTotalDistanceTraveledRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTotalDistanceTraveledTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(0, 4, 6),
                arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(6, 2)
                ),
                4L
            ),
            Arguments.of(
                listOf(1, -1),
                arrayOf(
                    intArrayOf(-2, 1),
                    intArrayOf(2, 1)
                ),
                2L
            )
        )
    }

    @Nested
    inner class MinimumTotalDistanceTraveledRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum total distance traveled by all the robots`(
            robot: List<Int>,
            factory: Array<IntArray>,
            expected: Long
        ) {
            MinimumTotalDistanceTraveledRev1().test(robot, factory, expected)
        }
    }
}

private fun MinimumTotalDistanceTraveled.test(robot: List<Int>, factory: Array<IntArray>, expected: Long) {
    val actual = minimumTotalDistance(robot, factory)
    assertEquals(expected, actual)
}
