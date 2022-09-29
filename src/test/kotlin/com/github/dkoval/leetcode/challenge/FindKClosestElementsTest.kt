package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindKClosestElements.FindKClosestElementsUsingBinarySearch
import com.github.dkoval.leetcode.challenge.FindKClosestElements.FindKClosestElementsUsingMaxHeap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class FindKClosestElementsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                3,
                listOf(1, 2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                -1,
                listOf(1, 2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                4,
                listOf(2, 3, 4, 5)
            )
        )
    }

    @Nested
    inner class FindKClosestElementsUsingMaxHeapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find k closest elements`(arr: IntArray, k: Int, x: Int, expected: List<Int>) {
            FindKClosestElementsUsingMaxHeap().test(arr, k, x, expected)
        }
    }

    @Nested
    inner class FindKClosestElementsUsingBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find k closest elements`(arr: IntArray, k: Int, x: Int, expected: List<Int>) {
            FindKClosestElementsUsingBinarySearch().test(arr, k, x, expected)
        }
    }

    private fun FindKClosestElements.test(arr: IntArray, k: Int, x: Int, expected: List<Int>) {
        val actual = findClosestElements(arr, k, x)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}