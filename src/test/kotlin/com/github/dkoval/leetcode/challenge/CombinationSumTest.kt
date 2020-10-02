package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CombinationSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 6, 7),
                7,
                listOf(
                    listOf(2, 2, 3),
                    listOf(7)
                )
            ),
            Arguments.of(
                intArrayOf(2, 3, 5),
                8,
                listOf(
                    listOf(2, 2, 2, 2),
                    listOf(2, 3, 3),
                    listOf(3, 5)
                )
            ),
            Arguments.of(
                intArrayOf(2),
                1,
                listOf<List<Int>>()
            ),
            Arguments.of(
                intArrayOf(1),
                1,
                listOf(
                    listOf(1)
                )
            ),
            Arguments.of(
                intArrayOf(1),
                2,
                listOf(
                    listOf(1, 1)
                )
            )
        )
    }

    @Nested
    inner class CombinationSumKtTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all unique combinations`(
            candidates: IntArray,
            target: Int,
            expected: List<List<Int>>
        ) {
            CombinationSumKt.test(candidates, target, expected)
        }
    }

    @Nested
    inner class CombinationSumJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all unique combinations`(
            candidates: IntArray,
            target: Int,
            expected: List<List<Int>>
        ) {
            CombinationSumJava().test(candidates, target, expected)
        }
    }

    private fun CombinationSum.test(candidates: IntArray, target: Int, expected: List<List<Int>>) {
        val actual = combinationSum(candidates, target)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}