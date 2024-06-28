package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumTotalImportanceOfRoads.MaximumTotalImportanceOfRoadsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumTotalImportanceOfRoadsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 4)
                ),
                43
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(2, 4),
                    intArrayOf(1, 3)
                ),
                20
            )
        )
    }

    @Nested
    inner class MaximumTotalImportanceOfRoadsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum total importance of all roads possible after assigning the values optimally`(
            n: Int,
            roads: Array<IntArray>,
            expected: Long
        ) {
            MaximumTotalImportanceOfRoadsRev1().test(n, roads, expected)
        }
    }
}

private fun MaximumTotalImportanceOfRoads.test(n: Int, roads: Array<IntArray>, expected: Long) {
    val actual = maximumImportance(n, roads)
    assertEquals(expected, actual)
}
