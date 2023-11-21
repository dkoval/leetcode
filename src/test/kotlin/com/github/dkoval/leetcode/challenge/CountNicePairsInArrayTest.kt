package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNicePairsInArray.CountNicePairsInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNicePairsInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(42, 11, 1, 97),
                2
            ),
            Arguments.of(
                intArrayOf(13, 10, 35, 24, 76),
                4
            )
        )
    }

    @Nested
    inner class CountNicePairsInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of nice pairs of indices`(nums: IntArray, expected: Int) {
            CountNicePairsInArrayRev1().test(nums, expected)
        }
    }
}

private fun CountNicePairsInArray.test(nums: IntArray, expected: Int) {
    val actual = countNicePairs(nums)
    assertEquals(expected, actual)
}
