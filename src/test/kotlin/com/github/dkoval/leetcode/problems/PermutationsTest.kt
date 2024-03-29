package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.Permutations.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PermutationsTest {

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
                intArrayOf(0, 1),
                listOf(
                    listOf(0, 1),
                    listOf(1, 0)
                )
            ),
            Arguments.of(
                intArrayOf(1),
                listOf(
                    listOf(1)
                )
            )
        )
    }

    @Nested
    inner class PermutationsRecursiveRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible permutations`(nums: IntArray, expected: List<List<Int>>) {
            PermutationsRecursiveRev1().test(nums, expected)
        }
    }

    @Nested
    inner class PermutationsRecursiveRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible permutations`(nums: IntArray, expected: List<List<Int>>) {
            PermutationsRecursiveRev2().test(nums, expected)
        }
    }

    @Nested
    inner class PermutationsHeapAlgorithmTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible permutations`(nums: IntArray, expected: List<List<Int>>) {
            PermutationsHeapAlgorithm().test(nums, expected)
        }
    }
}

private fun Permutations.test(nums: IntArray, expected: List<List<Int>>) {
    val actual = permute(nums)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
