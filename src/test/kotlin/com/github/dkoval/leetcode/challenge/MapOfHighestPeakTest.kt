package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MapOfHighestPeak.MapOfHighestPeakRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MapOfHighestPeakTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 0)
                ),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 0, 0)
                ),
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 2)
                )
            )
        )
    }

    @Nested
    inner class MapOfHighestPeakTestRev1 {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an integer matrix height`(isWatter: Array<IntArray>, expected: Array<IntArray>) {
            MapOfHighestPeakRev1().test(isWatter, expected)
        }
    }
}

private fun MapOfHighestPeak.test(isWatter: Array<IntArray>, expected: Array<IntArray>) {
    val actual = highestPeak(isWatter)
    assertArrayEquals(expected, actual)
}
