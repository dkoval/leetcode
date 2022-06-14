package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.CombinationSum2.CombinationSum2Rev1
import com.github.dkoval.leetcode.problems.CombinationSum2.CombinationSum2Rev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CombinationSum2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(10, 1, 2, 7, 6, 1, 5),
                8,
                listOf(
                    listOf(1, 1, 6),
                    listOf(1, 2, 5),
                    listOf(1, 7),
                    listOf(2, 6)
                )
            ),
            Arguments.of(
                intArrayOf(2, 5, 2, 1, 2),
                5,
                listOf(
                    listOf(1, 2, 2),
                    listOf(5)
                )
            )
        )
    }

    @Nested
    inner class CombinationSum2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all unique combinations in candidates where the candidate numbers sum to target`(
            candidates: IntArray,
            target: Int,
            expected: List<List<Int>>
        ) {
            CombinationSum2Rev1().test(candidates, target, expected)
        }
    }

    @Nested
    inner class CombinationSum2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all unique combinations in candidates where the candidate numbers sum to target`(
            candidates: IntArray,
            target: Int,
            expected: List<List<Int>>
        ) {
            CombinationSum2Rev2().test(candidates, target, expected)
        }
    }

    private fun CombinationSum2.test(candidates: IntArray, target: Int, expected: List<List<Int>>) {
        val actual = combinationSum2(candidates, target)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}