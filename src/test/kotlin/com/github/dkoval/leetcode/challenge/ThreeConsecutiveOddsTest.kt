package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ThreeConsecutiveOdds.ThreeConsecutiveOddsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ThreeConsecutiveOddsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 6, 4, 1),
                false
            ),
            Arguments.of(
                intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12),
                true
            )
        )
    }

    @Nested
    inner class ThreeConsecutiveOddsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if there are three consecutive odd numbers in the array`(arr: IntArray, expected: Boolean) {
            ThreeConsecutiveOddsRev1().test(arr, expected)
        }
    }
}

private fun ThreeConsecutiveOdds.test(arr: IntArray, expected: Boolean) {
    val actual = threeConsecutiveOdds(arr)
    assertEquals(expected, actual)
}