package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SeparateDigitsInArray.SeparateDigitsInArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SeparateDigitsInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(13, 25, 83, 77),
                intArrayOf(1, 3, 2, 5, 8, 3, 7, 7)
            ),
            Arguments.of(
                intArrayOf(7, 1, 3, 9),
                intArrayOf(7, 1, 3, 9)
            )
        )
    }

    @Nested
    inner class SeparateDigitsInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array that contains the digits of each integer in the input array`(
            nums: IntArray,
            expected: IntArray
        ) {
            SeparateDigitsInArrayRev1().test(nums, expected)
        }
    }
}

private fun SeparateDigitsInArray.test(nums: IntArray, expected: IntArray) {
    val actual = separateDigits(nums)
    assertArrayEquals(expected, actual)
}
