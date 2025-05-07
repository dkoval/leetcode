package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BuildArrayFromPermutation.BuildArrayFromPermutationRev1
import com.github.dkoval.leetcode.challenge.BuildArrayFromPermutation.BuildArrayFromPermutationRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BuildArrayFromPermutationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 2, 1, 5, 3, 4),
                intArrayOf(0, 1, 2, 4, 5, 3)
            ),
            Arguments.of(
                intArrayOf(5, 0, 1, 2, 3, 4),
                intArrayOf(4, 5, 0, 1, 2, 3)
            )
        )
    }

    @Nested
    inner class BuildArrayFromPermutationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should build array from permutation`(nums: IntArray, expected: IntArray) {
            BuildArrayFromPermutationRev1().test(nums.clone(), expected)
        }
    }

    @Nested
    inner class BuildArrayFromPermutationRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should build array from permutation with O(1) space`(nums: IntArray, expected: IntArray) {
            BuildArrayFromPermutationRev2().test(nums.clone(), expected)
        }
    }
}

private fun BuildArrayFromPermutation.test(nums: IntArray, expected: IntArray) {
    val actual = buildArray(nums)
    assertArrayEquals(expected, actual)
}
