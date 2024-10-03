package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MakeSumDivisibleByP.MakeSumDivisibleByPRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MakeSumDivisibleByPTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1, 4, 2),
                6,
                1
            ),
            Arguments.of(
                intArrayOf(6, 3, 5, 2),
                9,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                3,
                0
            )
        )
    }

    @Nested
    inner class MakeSumDivisibleByPRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the smallest subarray that you need to remove`(
            nums: IntArray,
            p: Int,
            expected: Int
        ) {
            MakeSumDivisibleByPRev1().test(nums, p, expected)
        }
    }
}

private fun MakeSumDivisibleByP.test(nums: IntArray, p: Int, expected: Int) {
    val actual = minSubarray(nums, p)
    assertEquals(expected, actual)
}
