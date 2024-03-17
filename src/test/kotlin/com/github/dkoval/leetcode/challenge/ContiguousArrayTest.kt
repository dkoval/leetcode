package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ContiguousArray.ContiguousArrayRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ContiguousArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(0, 1, 0),
                2
            ),
            Arguments.of(
                intArrayOf(0, 1, 0, 0, 1, 1, 0),
                6
            ),
            Arguments.of(
                intArrayOf(0, 0, 1, 0, 0, 0, 1, 1),
                6
            ),
            Arguments.of(
                intArrayOf(0, 1, 1, 0, 1, 1, 1, 0),
                4
            )
        )
    }

    @Nested
    inner class ContiguousArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum length of a contiguous subarray with equal number of 0 and 1`(
            nums: IntArray,
            expected: Int
        ) {
            ContiguousArrayRev1.test(nums, expected)
        }
    }

    @Nested
    inner class ContiguousArrayRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the maximum length of a contiguous subarray with equal number of 0 and 1`(
            nums: IntArray,
            expected: Int
        ) {
            ContiguousArrayRev2().test(nums, expected)
        }
    }
}

private fun ContiguousArray.test(nums: IntArray, expected: Int) {
    val actual = findMaxLength(nums)
    assertEquals(expected, actual)
}
