package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FourSum.FourSumUsingKSumWithHashSet
import com.github.dkoval.leetcode.challenge.FourSum.FourSumWithHashTableForSumOfPairs
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FourSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 0, -1, 0, -2, 2),
                0,
                listOf(
                    listOf(-2, -1, 1, 2),
                    listOf(-2, 0, 0, 2),
                    listOf(-1, 0, 0, 1)
                )
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                8,
                listOf(
                    listOf(2, 2, 2, 2)
                )
            )
        )
    }

    @Nested
    inner class FourSumWithHashTableForSumOfPairsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of all the unique quadruplets`(
            nums: IntArray,
            target: Int,
            expected: List<List<Int>>
        ) {
            FourSumWithHashTableForSumOfPairs().test(nums, target, expected)
        }
    }

    @Nested
    inner class FourSumUsingKSumWithHashSetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of all the unique quadruplets`(
            nums: IntArray,
            target: Int,
            expected: List<List<Int>>
        ) {
            FourSumUsingKSumWithHashSet().test(nums, target, expected)
        }
    }

    private fun FourSum.test(nums: IntArray, target: Int, expected: List<List<Int>>) {
        val actual = fourSum(nums, target)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}