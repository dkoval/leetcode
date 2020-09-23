package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MajorityElement2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 3),
                listOf(3)
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 3, 3, 2, 2, 2),
                listOf(1, 2)
            )
        )
    }

    @Nested
    inner class MajorityElement2UsingHashMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all elements that appear more than n div 3 times`(nums: IntArray, expected: List<Int>) {
            MajorityElement2UsingHashMap.test(nums, expected)
        }
    }

    @Nested
    inner class MajorityElement2UsingBoyerMooreVotingAlgorithmTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all elements that appear more than n div 3 times`(nums: IntArray, expected: List<Int>) {
            MajorityElement2UsingBoyerMooreVotingAlgorithm.test(nums, expected)
        }
    }


    private fun MajorityElement2.test(nums: IntArray, expected: List<Int>) {
        val actual = majorityElement(nums)
        assertEquals(expected, actual)
    }
}