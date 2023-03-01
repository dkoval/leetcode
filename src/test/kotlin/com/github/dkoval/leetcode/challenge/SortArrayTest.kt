package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortArray.SortArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 2, 3, 1),
                intArrayOf(1, 2, 3, 5)
            ),
            Arguments.of(
                intArrayOf(5, 1, 1, 2, 0, 0),
                intArrayOf(0, 0, 1, 1, 2, 5)
            )
        )
    }

    @Nested
    inner class SortArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort the array in ascending order and return it`(nums: IntArray, expected: IntArray) {
            SortArrayRev1().test(nums, expected)
        }
    }
}

private fun SortArray.test(nums: IntArray, expected: IntArray) {
    val actual = sortArray(nums)
    assertArrayEquals(expected, actual)
}
