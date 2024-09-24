package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLengthOfLongestCommonPrefix.FindLengthOfLongestCommonPrefixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLengthOfLongestCommonPrefixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 10, 100),
                intArrayOf(1000),
                3
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 4, 4),
                0
            )
        )
    }

    @Nested
    inner class FindLengthOfLongestCommonPrefixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest common prefix among all pairs`(
            arr1: IntArray,
            arr2: IntArray,
            expected: Int
        ) {
            FindLengthOfLongestCommonPrefixRev1().test(arr1, arr2, expected)
        }
    }
}

private fun FindLengthOfLongestCommonPrefix.test(arr1: IntArray, arr2: IntArray, expected: Int) {
    val actual = longestCommonPrefix(arr1, arr2)
    assertEquals(expected, actual)
}
