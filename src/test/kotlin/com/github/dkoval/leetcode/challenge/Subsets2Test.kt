package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Subsets2.Subsets2Recursive
import com.github.dkoval.leetcode.challenge.Subsets2.Subsets2Recursive2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class Subsets2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2),
                listOf(
                    listOf(),
                    listOf(1),
                    listOf(1, 2),
                    listOf(1, 2, 2),
                    listOf(2),
                    listOf(2, 2)
                )
            ),
            Arguments.of(
                intArrayOf(0),
                listOf(
                    listOf(),
                    listOf(0)
                )
            ),
            Arguments.of(
                intArrayOf(4, 4, 4, 1, 4),
                listOf(
                    listOf(),
                    listOf(1),
                    listOf(1, 4),
                    listOf(1, 4, 4),
                    listOf(1, 4, 4, 4),
                    listOf(1, 4, 4, 4, 4),
                    listOf(4),
                    listOf(4, 4),
                    listOf(4, 4, 4),
                    listOf(4, 4, 4, 4)
                )
            )
        )
    }

    @Nested
    inner class Subsets2RecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible subsets in any order`(nums: IntArray, expected: List<List<Int>>) {
            Subsets2Recursive().test(nums, expected)
        }
    }

    @Nested
    inner class Subsets2Recursive2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible subsets in any order`(nums: IntArray, expected: List<List<Int>>) {
            Subsets2Recursive2().test(nums, expected)
        }
    }

    private fun Subsets2.test(nums: IntArray, expected: List<List<Int>>) {
        val actual = subsetsWithDup(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}