package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ClimbingStairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            // 1. 1 step + 1 step
            // 2. 2 steps
            Arguments.of(2, 2),
            // 1. 1 step + 1 step + 1 step
            // 2. 1 step + 2 steps
            // 3. 2 steps + 1 step
            Arguments.of(3, 3),
            Arguments.of(4, 5)
        )
    }

    @Nested
    inner class ClimbingStairsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct ways you can climb to the top`(n: Int, expected: Int) {
            ClimbingStairsDPTopDown.test(n, expected)
        }
    }

    @Nested
    inner class ClimbingStairsFibonacciSeqTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct ways you can climb to the top`(n: Int, expected: Int) {
            ClimbingStairsFibonacciSeq.test(n, expected)
        }
    }

    private fun ClimbingStairs.test(n: Int, expected: Int) {
        val actual = climbStairs(n)
        assertEquals(expected, actual)
    }
}