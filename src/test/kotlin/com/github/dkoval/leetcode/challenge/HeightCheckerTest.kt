package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.HeightChecker.HeightCheckerRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HeightCheckerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 4, 2, 1, 3),
                3
            ),
            Arguments.of(
                intArrayOf(5, 1, 2, 3, 4),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                0
            )
        )
    }

    @Nested
    inner class HeightCheckerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of indices where heights(i) != expected(i)`(heights: IntArray, expected: Int) {
            HeightCheckerRev1().test(heights, expected)
        }
    }
}

private fun HeightChecker.test(heights: IntArray, expected: Int) {
    val actual = heightChecker(heights)
    assertEquals(expected, actual)
}
