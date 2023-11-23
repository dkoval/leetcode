package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ArithmeticSubarrays.ArithmeticSubarraysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ArithmeticSubarraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 6, 5, 9, 3, 7),
                intArrayOf(0, 0, 2),
                intArrayOf(2, 3, 5),
                listOf(true, false, true)
            ),
            Arguments.of(
                intArrayOf(-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10),
                intArrayOf(0, 1, 6, 4, 8, 7),
                intArrayOf(4, 4, 9, 7, 9, 10),
                listOf(false, true, false, false, true, true)
            )
        )
    }

    @Nested
    inner class ArithmeticSubarraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the subarray can be rearranged to form an arithmetic sequence`(
            nums: IntArray,
            l: IntArray,
            r: IntArray,
            expected: List<Boolean>
        ) {
            ArithmeticSubarraysRev1().test(nums, l, r, expected)
        }
    }
}

private fun ArithmeticSubarrays.test(nums: IntArray, l: IntArray, r: IntArray, expected: List<Boolean>) {
    val actual = checkArithmeticSubarrays(nums, l, r)
    assertEquals(expected, actual)
}
