package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KeepMultiplyingFoundValuesByTwo.KeepMultiplyingFoundValuesByTwoRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KeepMultiplyingFoundValuesByTwoTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 3, 6, 1, 12),
                3,
                24
            ),
            Arguments.of(
                intArrayOf(2, 7, 9),
                4,
                4
            )
        )
    }

    @Nested
    inner class KeepMultiplyingFoundValuesByTwoRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final value of original after performing the operations`(
            nums: IntArray,
            original: Int,
            expected: Int
        ) {
            KeepMultiplyingFoundValuesByTwoRev1().test(nums, original, expected)
        }
    }
}

private fun KeepMultiplyingFoundValuesByTwo.test(nums: IntArray, original: Int, expected: Int) {
    val actual = findFinalValue(nums, original)
    assertEquals(expected, actual)
}
