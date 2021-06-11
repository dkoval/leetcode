package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StoneGame7.StoneGame7TopDownWithMemoization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StoneGame7Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 3, 1, 4, 2),
                6
            ),
            Arguments.of(
                intArrayOf(7, 90, 5, 1, 100, 10, 10, 2),
                122
            )
        )
    }

    @Nested
    inner class StoneGame7TopDownWithMemoizationTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the difference in Alice and Bob's score if they both play optimally`(
            stones: IntArray,
            expected: Int
        ) {
            StoneGame7TopDownWithMemoization().test(stones, expected)
        }
    }

    private fun StoneGame7.test(stones: IntArray, expected: Int) {
        val actual = stoneGameVII(stones)
        assertEquals(expected, actual)
    }
}