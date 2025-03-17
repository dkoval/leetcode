package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivideArrayIntoEqualPairs.DivideArrayIntoEqualPairsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DivideArrayIntoEqualPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 3, 2, 2, 2),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                false
            )
        )
    }

    @Nested
    inner class DivideArrayIntoEqualPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if nums can be divided into n pairs`(nums: IntArray, expected: Boolean) {
            DivideArrayIntoEqualPairsRev1().test(nums, expected)
        }
    }
}

private fun DivideArrayIntoEqualPairs.test(nums: IntArray, expected: Boolean) {
    val actual = divideArray(nums)
    assertEquals(expected, actual)
}
