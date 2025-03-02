package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MergeTwo2DArraysBySummingValues.MergeTwo2DArraysBySummingValuesRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MergeTwo2DArraysBySummingValuesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(4, 5)
                ),
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(3, 2),
                    intArrayOf(4, 1)
                ),
                arrayOf(
                    intArrayOf(1, 6),
                    intArrayOf(2, 3),
                    intArrayOf(3, 2),
                    intArrayOf(4, 6)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 4),
                    intArrayOf(3, 6),
                    intArrayOf(5, 5)
                ),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(4, 3)
                ),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 4),
                    intArrayOf(3, 6),
                    intArrayOf(4, 3),
                    intArrayOf(5, 5)
                )
            )
        )
    }

    @Nested
    inner class MergeTwo2DArraysBySummingValuesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should merge the two arrays into one array that is sorted in ascending order by id`(
            nums1: Array<IntArray>,
            nums2: Array<IntArray>,
            expected: Array<IntArray>
        ) {
            MergeTwo2DArraysBySummingValuesRev1().test(nums1, nums2, expected)
        }
    }
}

private fun MergeTwo2DArraysBySummingValues.test(
    nums1: Array<IntArray>,
    nums2: Array<IntArray>,
    expected: Array<IntArray>
) {
    val actual = mergeArrays(nums1, nums2)
    assertArrayEquals(expected, actual)
}
