package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.PeakIndexInMountainArray.PeakIndexInMountainArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class PeakIndexInMountainArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 0),
                1
            ),
            Arguments.of(
                intArrayOf(0, 2, 1, 0),
                1
            ),
            Arguments.of(
                intArrayOf(0, 10, 5, 2),
                1
            ),
            Arguments.of(
                intArrayOf(24, 69, 100, 99, 79, 78, 67, 36, 26, 19),
                2
            ),
            Arguments.of(
                intArrayOf(3, 5, 3, 2, 0),
                1
            )
        )
    }

    @Nested
    inner class PeakIndexInMountainArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the peak index in a mountain array`(arr: IntArray, expected: Int) {
            PeakIndexInMountainArrayRev1().test(arr, expected)
        }
    }

    private fun PeakIndexInMountainArray.test(arr: IntArray, expected: Int) {
        val actual = peakIndexInMountainArray(arr)
        assertEquals(expected, actual)
    }
}