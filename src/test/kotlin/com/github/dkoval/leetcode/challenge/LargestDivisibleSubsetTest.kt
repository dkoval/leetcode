package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestDivisibleSubset.LargestDivisibleSubsetDPBottomUpWithPathReconstruction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestDivisibleSubsetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                listOf(1, 2)
            ),
            Arguments.of(
                intArrayOf(1, 2, 4, 8),
                listOf(1, 2, 4, 8)
            )
        )
    }

    @Nested
    inner class LargestDivisibleSubsetDPBottomUpWithPathReconstructionTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest divisible subset`(nums: IntArray, expected: List<Int>) {
            LargestDivisibleSubsetDPBottomUpWithPathReconstruction().test(nums, expected)
        }
    }

    @Nested
    inner class LargestDivisibleSubsetKnowledgeCenterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest divisible subset`(nums: IntArray, expected: List<Int>) {
            LargestDivisibleSubsetKnowledgeCenter.test(nums, expected)
        }
    }
}

private fun LargestDivisibleSubset.test(nums: IntArray, expected: List<Int>) {
    val actual = largestDivisibleSubset(nums)
    assertEquals(expected, actual)
}
