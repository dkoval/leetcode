package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindHighestAltitude.FindHighestAltitudeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindHighestAltitudeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-5, 1, 5, 0, -7),
                1
            ),
            Arguments.of(
                intArrayOf(-4, -3, -2, -1, 4, 3, 2),
                0
            )
        )
    }

    @Nested
    inner class FindHighestAltitudeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the highest altitude of a point`(gain: IntArray, expected: Int) {
            FindHighestAltitudeRev1().test(gain, expected)
        }
    }
}

private fun FindHighestAltitude.test(gain: IntArray, expected: Int) {
    val actual = largestAltitude(gain)
    assertEquals(expected, actual)
}
