package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.MajorityElementDivideAndConquer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MajorityElementTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 3),
                3
            ),
            Arguments.of(
                intArrayOf(2, 2, 1, 1, 1, 2, 2),
                2
            )
        )
    }

    @Nested
    inner class MajorityElementUsingHashMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should ind the majority element`(nums: IntArray, expected: Int) {
            MajorityElementUsingHashMap.test(nums, expected)
        }
    }

    @Nested
    inner class MajorityElementDivideAndConquerTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should ind the majority element`(nums: IntArray, expected: Int) {
            MajorityElementDivideAndConquer().test(nums, expected)
        }
    }

    @Nested
    inner class MajorityElementUsingBoyerMooreVotingAlgorithmTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should ind the majority element`(nums: IntArray, expected: Int) {
            MajorityElementUsingBoyerMooreVotingAlgorithm.test(nums, expected)
        }
    }

    private fun MajorityElement.test(nums: IntArray, expected: Int) {
        val actual = majorityElement(nums)
        assertEquals(expected, actual)
    }
}