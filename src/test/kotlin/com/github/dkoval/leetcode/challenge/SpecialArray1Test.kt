package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SpecialArray1.SpecialArray1Rev1
import com.github.dkoval.leetcode.challenge.SpecialArray1.SpecialArray1Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SpecialArray1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1),
                true
            ),
            Arguments.of(
                intArrayOf(2, 1, 4),
                true
            ),
            Arguments.of(
                intArrayOf(4, 3, 1, 6),
                false
            )
        )
    }

    @Nested
    inner class SpecialArray1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if if array nums is special`(
            nums: IntArray, expected: Boolean
        ) {
            SpecialArray1Rev1().test(nums, expected)
        }
    }

    @Nested
    inner class SpecialArray1Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if if array nums is special`(
            nums: IntArray, expected: Boolean
        ) {
            SpecialArray1Rev2().test(nums, expected)
        }
    }
}

private fun SpecialArray1.test(nums: IntArray, expected: Boolean) {
    val actual = isArraySpecial(nums)
    assertEquals(expected, actual)
}
