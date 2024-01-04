package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMakeArrayEmpty.MinimumNumberOfOperationsToMakeArrayEmptyRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfOperationsToMakeArrayEmptyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4),
                4
            ),
            Arguments.of(
                intArrayOf(2, 1, 2, 2, 3, 3),
                -1
            ),
            Arguments.of(
                intArrayOf(14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12),
                7
            ),
            Arguments.of(
                intArrayOf(19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19),
                5
            ),
            Arguments.of(
                intArrayOf(11, 11, 11, 11, 19, 11, 11, 11, 11, 11, 19, 11, 11, 11, 11, 11, 19),
                6
            )
        )
    }

    @Nested
    inner class MinimumNumberOfOperationsToMakeArrayEmptyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations required to make the array empty, or -1 if it is not possible`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumNumberOfOperationsToMakeArrayEmptyRev1().test(nums, expected)
        }
    }
}

private fun MinimumNumberOfOperationsToMakeArrayEmpty.test(nums: IntArray, expected: Int) {
    val actual = minOperations(nums)
    assertEquals(expected, actual)
}
