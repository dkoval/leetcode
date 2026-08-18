package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLargestAlmostMissingInteger.FindLargestAlmostMissingIntegerRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class FindLargestAlmostMissingIntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 9, 2, 1, 7),
                3,
                7
            ),
            Arguments.of(
                intArrayOf(3, 9, 7, 2, 1, 7),
                4,
                3
            ),
            Arguments.of(
                intArrayOf(0, 0),
                1,
                -1
            ),
            Arguments.of(
                intArrayOf(4, 4, 2, 2, 2, 0, 5, 3, 4, 4),
                3,
                -1
            ),
            Arguments.of(
                intArrayOf(8, 6, 2, 8, 6),
                4,
                -1
            )
        )
    }

    @Nested
    inner class FindLargestAlmostMissingIntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest almost missing integer from nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            FindLargestAlmostMissingIntegerRev1().test(nums, k, expected)
        }
    }
}

private fun FindLargestAlmostMissingInteger.test(nums: IntArray, k: Int, expected: Int) {
    val actual = largestInteger(nums, k)
    assertEquals(expected, actual)
}
