package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TrionicArray2.TrionicArray2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class TrionicArray2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(0, -2, -1, -3, 0, 2, -1),
                -4L
            ),
            arguments(
                intArrayOf(1, 4, 2, 7),
                14L
            )
        )
    }

    @Nested
    inner class TrionicArray2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of any trionic subarray in nums`(nums: IntArray, expected: Long) {
            TrionicArray2Rev1().test(nums, expected)
        }
    }
}

private fun TrionicArray2.test(nums: IntArray, expected: Long) {
    val actual = maxSumTrionic(nums)
    assertEquals(expected, actual)
}
