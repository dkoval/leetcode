package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TrionicArray1.TrionicArray1Rev1
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

internal class TrionicArray1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(1, 3, 5, 4, 2, 6),
                true
            ),
            arguments(
                intArrayOf(2, 1, 3),
                false
            ),
            arguments(
                intArrayOf(3, 7, 1),
                false
            ),
            arguments(
                intArrayOf(6, 7, 5, 1),
                false
            )
        )
    }

    @Nested
    inner class TrionicArray1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if the given array is a trionic array`(
            nums: IntArray,
            expected: Boolean
        ) {
            TrionicArray1Rev1().test(nums, expected)
        }
    }
}

private fun TrionicArray1.test(nums: IntArray, expected: Boolean) {
    val actual = isTrionic(nums)
    assertEquals(expected, actual)
}
