package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortIntegersByNumberOf1Bits.SortIntegersByNumberOf1BitsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SortIntegersByNumberOf1BitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
                intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7)
            ),
            arguments(
                intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1),
                intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)
            )
        )
    }

    @Nested
    inner class SortIntegersByNumberOf1BitsIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort the array by the number of 1 bits in their binary representation`(
            arr: IntArray,
            expected: IntArray
        ) {
            SortIntegersByNumberOf1BitsRev1().test(arr, expected)
        }
    }
}

private fun SortIntegersByNumberOf1Bits.test(arr: IntArray, expected: IntArray) {
    val actual = sortByBits(arr)
    assertArrayEquals(expected, actual)
}
