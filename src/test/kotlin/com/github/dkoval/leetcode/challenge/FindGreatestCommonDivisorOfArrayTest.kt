package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindGreatestCommonDivisorOfArray.FindGreatestCommonDivisorOfArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindGreatestCommonDivisorOfArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 5, 6, 9, 10),
                2
            ),
            Arguments.of(
                intArrayOf(7, 5, 6, 8, 3),
                1
            ),
            Arguments.of(
                intArrayOf(3, 3),
                3
            )
        )
    }

    @Nested
    inner class FindGreatestCommonDivisorOfArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the greatest common divisor of the smallest number and largest number in nums`(
            nums: IntArray,
            expected: Int
        ) {
            FindGreatestCommonDivisorOfArrayRev1().test(nums, expected)
        }
    }
}

private fun FindGreatestCommonDivisorOfArrayRev1.test(nums: IntArray, expected: Int) {
    val actual = findGCD(nums)
    assertEquals(expected, actual)
}
