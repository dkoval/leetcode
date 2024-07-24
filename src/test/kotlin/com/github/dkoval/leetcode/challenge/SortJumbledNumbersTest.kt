package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortJumbledNumbers.SortJumbledNumbersRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortJumbledNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6),
                intArrayOf(991, 338, 38),
                intArrayOf(338, 38, 991)
            ),
            Arguments.of(
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(789, 456, 123),
                intArrayOf(123, 456, 789)
            ),
            Arguments.of(
                intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
            )
        )
    }

    @Nested
    inner class SortJumbledNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the array nums sorted in non-decreasing order based on the mapped values of its elements`(
            mapping: IntArray,
            nums: IntArray,
            expected: IntArray
        ) {
            SortJumbledNumbersRev1().test(mapping, nums, expected)
        }
    }
}

private fun SortJumbledNumbers.test(mapping: IntArray, nums: IntArray, expected: IntArray) {
    val actual = sortJumbled(mapping, nums)
    assertArrayEquals(expected, actual)
}
