package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SubsetsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Stream.of(
                Arguments.of(
                    intArrayOf(1, 2, 3),
                    listOf(
                        listOf(3),
                        listOf(1),
                        listOf(2),
                        listOf(1, 2, 3),
                        listOf(1, 3),
                        listOf(2, 3),
                        listOf(1, 2),
                        emptyList()
                    )
                )
            )
    }

    @Nested
    inner class SubsetsBitmaskTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible subsets`(nums: IntArray, expected: List<List<Int>>) {
            SubsetsBitmask.test(nums, expected)
        }
    }

    @Nested
    inner class SubsetsIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible subsets`(nums: IntArray, expected: List<List<Int>>) {
            SubsetsIter.test(nums, expected)
        }
    }

    @Nested
    inner class SubsetsRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible subsets`(nums: IntArray, expected: List<List<Int>>) {
            SubsetsRecursive.test(nums, expected)
        }
    }

    private fun Subsets.test(nums: IntArray, expected: List<List<Int>>) {
        val actual = subsets(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}