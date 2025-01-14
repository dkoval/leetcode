package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindPrefixCommonArrayOfTwoArrays.FindPrefixCommonArrayOfTwoArraysRev1
import com.github.dkoval.leetcode.challenge.FindPrefixCommonArrayOfTwoArrays.FindPrefixCommonArrayOfTwoArraysRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindPrefixCommonArrayOfTwoArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2, 4),
                intArrayOf(3, 1, 2, 4),
                intArrayOf(0, 2, 3, 4)
            ),
            Arguments.of(
                intArrayOf(2, 3, 1),
                intArrayOf(3, 1, 2),
                intArrayOf(0, 1, 3)
            )
        )
    }

    @Nested
    inner class FindPrefixCommonArrayOfTwoArraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the prefix common array of A and B`(A: IntArray, B: IntArray, expected: IntArray) {
            FindPrefixCommonArrayOfTwoArraysRev1().test(A, B, expected)
        }
    }

    @Nested
    inner class FindPrefixCommonArrayOfTwoArraysRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the prefix common array of A and B`(A: IntArray, B: IntArray, expected: IntArray) {
            FindPrefixCommonArrayOfTwoArraysRev2().test(A, B, expected)
        }
    }
}

private fun FindPrefixCommonArrayOfTwoArrays.test(A: IntArray, B: IntArray, expected: IntArray) {
    val actual = findThePrefixCommonArray(A, B)
    assertArrayEquals(expected, actual)
}
