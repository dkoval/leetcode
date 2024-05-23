package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfBeautifulSubsets.NumberOfBeautifulSubsetsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfBeautifulSubsetsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 4, 6),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(1),
                1,
                1
            )
        )
    }

    @Nested
    inner class NumberOfBeautifulSubsetsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of non-empty beautiful subsets of the array nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            NumberOfBeautifulSubsetsRev1().test(nums, k, expected)
        }
    }
}

private fun NumberOfBeautifulSubsets.test(nums: IntArray, k: Int, expected: Int) {
    val actual = beautifulSubsets(nums, k)
    assertEquals(expected, actual)
}
