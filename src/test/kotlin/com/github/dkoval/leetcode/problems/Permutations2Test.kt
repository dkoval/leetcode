package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.Permutations2.Permutations2RecursiveNaive
import com.github.dkoval.leetcode.problems.Permutations2.Permutations2RecursiveOptimized
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Permutations2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                listOf(
                    listOf(1, 2, 3),
                    listOf(1, 3, 2),
                    listOf(2, 1, 3),
                    listOf(2, 3, 1),
                    listOf(3, 1, 2),
                    listOf(3, 2, 1)
                )
            ),
            Arguments.of(
                intArrayOf(1, 1, 2),
                listOf(
                    listOf(1, 1, 2),
                    listOf(1, 2, 1),
                    listOf(2, 1, 1)
                )
            ),
            Arguments.of(
                intArrayOf(3, 3, 0, 3),
                listOf(
                    listOf(0, 3, 3, 3),
                    listOf(3, 0, 3, 3),
                    listOf(3, 3, 0, 3),
                    listOf(3, 3, 3, 0)
                )
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 0, 9),
                listOf(
                    listOf(0, 0, 0, 1, 9),
                    listOf(0, 0, 0, 9, 1),
                    listOf(0, 0, 1, 0, 9),
                    listOf(0, 0, 1, 9, 0),
                    listOf(0, 0, 9, 0, 1),
                    listOf(0, 0, 9, 1, 0),
                    listOf(0, 1, 0, 0, 9),
                    listOf(0, 1, 0, 9, 0),
                    listOf(0, 1, 9, 0, 0),
                    listOf(0, 9, 0, 0, 1),
                    listOf(0, 9, 0, 1, 0),
                    listOf(0, 9, 1, 0, 0),
                    listOf(1, 0, 0, 0, 9),
                    listOf(1, 0, 0, 9, 0),
                    listOf(1, 0, 9, 0, 0),
                    listOf(1, 9, 0, 0, 0),
                    listOf(9, 0, 0, 0, 1),
                    listOf(9, 0, 0, 1, 0),
                    listOf(9, 0, 1, 0, 0),
                    listOf(9, 1, 0, 0, 0)
                )
            ),
        )
    }

    @Nested
    inner class Permutations2RecursiveNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible unique permutations in any order`(nums: IntArray, expected: List<List<Int>>) {
            Permutations2RecursiveNaive().test(nums, expected)
        }
    }

    @Nested
    inner class Permutations2RecursiveOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible unique permutations in any order`(nums: IntArray, expected: List<List<Int>>) {
            Permutations2RecursiveOptimized().test(nums, expected)
        }
    }

    private fun Permutations2.test(nums: IntArray, expected: List<List<Int>>) {
        val actual = permuteUnique(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}