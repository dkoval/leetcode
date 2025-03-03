package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PartitionArrayAccordingToGivenPivot.PartitionArrayAccordingToGivenPivotRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionArrayAccordingToGivenPivotTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(9, 12, 5, 10, 14, 3, 10),
                10,
                intArrayOf(9, 5, 3, 10, 10, 12, 14)
            ),
            Arguments.of(
                intArrayOf(-3, 4, 3, 2),
                2,
                intArrayOf(-3, 2, 4, 3)
            )
        )
    }

    @Nested
    inner class PartitionArrayAccordingToGivenPivotRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should partition the array according to the given pivot value`(
            nums: IntArray,
            pivot: Int,
            expected: IntArray
        ) {
            PartitionArrayAccordingToGivenPivotRev1().test(nums, pivot, expected)
        }
    }
}

private fun PartitionArrayAccordingToGivenPivot.test(nums: IntArray, pivot: Int, expected: IntArray) {
    val actual = pivotArray(nums, pivot)
    assertArrayEquals(expected, actual)
}
