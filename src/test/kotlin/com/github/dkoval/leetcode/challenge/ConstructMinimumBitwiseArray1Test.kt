package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConstructMinimumBitwiseArray1.ConstructMinimumBitwiseArray1Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConstructMinimumBitwiseArray1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(2, 3, 5, 7),
                intArrayOf(-1, 1, 4, 3)
            ),
            Arguments.of(
                listOf(11, 13, 31),
                intArrayOf(9, 12, 15)
            )
        )
    }

    @Nested
    inner class ConstructMinimumBitwiseArray1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should construct the minimum bitwise array`(nums: List<Int>, expected: IntArray) {
            ConstructMinimumBitwiseArray1Rev1().test(nums, expected)
        }
    }
}

private fun ConstructMinimumBitwiseArray1.test(nums: List<Int>, expected: IntArray) {
    val actual = minBitwiseArray(nums)
    assertArrayEquals(expected, actual)
}
