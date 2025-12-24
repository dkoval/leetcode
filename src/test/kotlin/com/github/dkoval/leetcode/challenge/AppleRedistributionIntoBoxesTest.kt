package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AppleRedistributionIntoBoxes.AppleRedistributionIntoBoxesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AppleRedistributionIntoBoxesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2),
                intArrayOf(4, 3, 1, 5, 2),
                2
            ),
            Arguments.of(
                intArrayOf(5, 5, 5),
                intArrayOf(2, 4, 2, 7),
                4
            ),
            Arguments.of(
                intArrayOf(1, 8, 6, 8, 9, 3, 3),
                intArrayOf(10, 6, 8, 7, 3, 6),
                6
            )
        )
    }

    @Nested
    inner class AppleRedistributionIntoBoxesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of boxes you need to select to redistribute these n packs of apple`(
            apple: IntArray,
            capacity: IntArray,
            expected: Int
        ) {
            AppleRedistributionIntoBoxesRev1().test(apple, capacity, expected)
        }
    }
}

private fun AppleRedistributionIntoBoxesRev1.test(apple: IntArray, capacity: IntArray, expected: Int) {
    val actual = minimumBoxes(apple, capacity)
    assertEquals(expected, actual)
}
