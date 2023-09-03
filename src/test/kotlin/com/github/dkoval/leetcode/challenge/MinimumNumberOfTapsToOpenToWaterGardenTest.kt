package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfTapsToOpenToWaterGarden.MinimumNumberOfTapsToOpenToWaterGardenRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfTapsToOpenToWaterGardenTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                intArrayOf(3, 4, 1, 1, 0, 0),
                1
            ),
            Arguments.of(
                3,
                intArrayOf(0, 0, 0, 0),
                -1
            ),
            Arguments.of(
                7,
                intArrayOf(1, 2, 1, 0, 2, 1, 0, 1),
                3
            )
        )
    }

    @Nested
    inner class MinimumNumberOfTapsToOpenToWaterGardenRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of taps that should be open to water the whole garden`(
            n: Int,
            ranges: IntArray,
            expected: Int
        ) {
            MinimumNumberOfTapsToOpenToWaterGardenRev1().test(n, ranges, expected)
        }
    }
}

private fun MinimumNumberOfTapsToOpenToWaterGarden.test(n: Int, ranges: IntArray, expected: Int) {
    val actual = minTaps(n, ranges)
    assertEquals(expected, actual)
}
