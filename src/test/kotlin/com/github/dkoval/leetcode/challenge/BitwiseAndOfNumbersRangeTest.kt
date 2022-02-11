package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BitwiseAndOfNumbersRange.BitwiseAndOfNumbersLarry
import com.github.dkoval.leetcode.challenge.BitwiseAndOfNumbersRange.BitwiseAndOfNumbersRangeByFindingCommonPrefix
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BitwiseAndOfNumbersRangeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(5, 7, 4),
            Arguments.of(0, 0, 0),
            Arguments.of(1, 2147483647, 0)
        )
    }

    @Nested
    inner class BitwiseAndOfNumbersRangeByFindingCommonPrefixTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the bitwise AND of all numbers in the given range, inclusive`(
            left: Int,
            right: Int,
            expected: Int
        ) {
            BitwiseAndOfNumbersRangeByFindingCommonPrefix().test(left, right, expected)
        }
    }

    @Nested
    inner class BitwiseAndOfNumbersLarryTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the bitwise AND of all numbers in the given range, inclusive`(
            left: Int,
            right: Int,
            expected: Int
        ) {
            BitwiseAndOfNumbersLarry().test(left, right, expected)
        }
    }

    private fun BitwiseAndOfNumbersRange.test(left: Int, right: Int, expected: Int) {
        val actual = rangeBitwiseAnd(left, right)
        assertEquals(expected, actual)
    }
}