package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestCombinationWithBitwiseANDGreaterThanZero.LargestCombinationWithBitwiseANDGreaterThanZeroRev1
import com.github.dkoval.leetcode.challenge.LargestCombinationWithBitwiseANDGreaterThanZero.LargestCombinationWithBitwiseANDGreaterThanZeroRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestCombinationWithBitwiseANDGreaterThanZeroTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(16, 17, 71, 62, 12, 24, 14),
                4
            ),
            Arguments.of(
                intArrayOf(8, 8),
                2
            )
        )
    }

    @Nested
    inner class LargestCombinationWithBitwiseANDGreaterThanZeroRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the largest combination of candidates with a bitwise AND greater than 0`(
            candidates: IntArray,
            expected: Int
        ) {
            LargestCombinationWithBitwiseANDGreaterThanZeroRev1().test(candidates, expected)
        }
    }

    @Nested
    inner class LargestCombinationWithBitwiseANDGreaterThanZeroRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the size of the largest combination of candidates with a bitwise AND greater than 0`(
            candidates: IntArray,
            expected: Int
        ) {
            LargestCombinationWithBitwiseANDGreaterThanZeroRev2().test(candidates, expected)
        }
    }
}

private fun LargestCombinationWithBitwiseANDGreaterThanZero.test(candidates: IntArray, expected: Int) {
    val actual = largestCombination(candidates)
    assertEquals(expected, actual)
}
