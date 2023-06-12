package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SummaryRanges.SummaryRangesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SummaryRangesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 2, 4, 5, 7),
                listOf("0->2", "4->5", "7")
            ),
            Arguments.of(
                intArrayOf(0, 2, 3, 4, 6, 8, 9),
                listOf("0", "2->4", "6", "8->9")
            ),
            Arguments.of(
                intArrayOf(),
                emptyList<String>()
            ),
            Arguments.of(
                intArrayOf(-2147483648, -2147483647, 2147483647),
                listOf("-2147483648->-2147483647", "2147483647")
            )
        )
    }

    @Nested
    inner class SummaryRangesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest sorted list of ranges that cover all the numbers in the array exactly`(
            nums: IntArray,
            expected: List<String>
        ) {
            SummaryRangesRev1().test(nums, expected)
        }
    }
}

private fun SummaryRanges.test(nums: IntArray, expected: List<String>) {
    val actual = summaryRanges(nums)
    assertEquals(expected, actual)
}
