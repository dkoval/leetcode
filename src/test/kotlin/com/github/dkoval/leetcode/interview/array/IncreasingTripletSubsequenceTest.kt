package com.github.dkoval.leetcode.interview.array

import com.github.dkoval.leetcode.interview.array.IncreasingTripletSubsequence.IncreasingTripletSubsequenceUsingExtraSpace
import com.github.dkoval.leetcode.interview.array.IncreasingTripletSubsequence.IncreasingTripletSubsequenceWithoutExtraSpace
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IncreasingTripletSubsequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                true
            ),
            Arguments.of(
                intArrayOf(5, 4, 3, 2, 1),
                false
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1),
                false
            ),
            Arguments.of(
                intArrayOf(10, 20, 3, 2, 1, 1, 2, 0, 4),
                true
            ),
            Arguments.of(
                intArrayOf(),
                false
            ),
            Arguments.of(
                intArrayOf(1),
                false
            ),
            Arguments.of(
                intArrayOf(1, 2),
                false
            )
        )
    }

    @Nested
    inner class IncreasingTripletSubsequenceUsingExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return whether an increasing subsequence of length 3 exists or not in the array`(
            nums: IntArray,
            expected: Boolean
        ) {
            IncreasingTripletSubsequenceUsingExtraSpace().test(nums, expected)
        }
    }

    @Nested
    inner class IncreasingTripletSubsequenceWithoutExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return whether an increasing subsequence of length 3 exists or not in the array`(
            nums: IntArray,
            expected: Boolean
        ) {
            IncreasingTripletSubsequenceWithoutExtraSpace().test(nums, expected)
        }
    }

    private fun IncreasingTripletSubsequence.test(nums: IntArray, expected: Boolean) {
        val actual = increasingTriplet(nums)
        assertEquals(expected, actual)
    }
}