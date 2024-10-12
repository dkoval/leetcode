package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivideIntervalsIntoMinimumNumberOfGroups.DivideIntervalsIntoMinimumNumberOfGroupsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DivideIntervalsIntoMinimumNumberOfGroupsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 10),
                    intArrayOf(6, 8),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(1, 10)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(5, 6),
                    intArrayOf(8, 10),
                    intArrayOf(11, 13)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(351436, 933571),
                    intArrayOf(667214, 975379),
                    intArrayOf(782454, 919174),
                    intArrayOf(231661, 764081),
                    intArrayOf(848495, 902497),
                    intArrayOf(332817, 520328),
                    intArrayOf(740795, 762394),
                    intArrayOf(665739, 726786),
                    intArrayOf(546865, 686588),
                    intArrayOf(360501, 846864)
                ),
                6
            )
        )
    }

    @Nested
    inner class DivideIntervalsIntoMinimumNumberOfGroupsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of groups you need to make`(intervals: Array<IntArray>, expected: Int) {
            DivideIntervalsIntoMinimumNumberOfGroupsRev1().test(intervals, expected)
        }
    }
}

private fun DivideIntervalsIntoMinimumNumberOfGroups.test(intervals: Array<IntArray>, expected: Int) {
    val actual = minGroups(intervals)
    assertEquals(expected, actual)
}
