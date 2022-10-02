package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfDiceRollsWithTargetSum.NumberOfDiceRollsWithTargetSumDPTopDown
import com.github.dkoval.leetcode.challenge.NumberOfDiceRollsWithTargetSum.NumberOfDiceRollsWithTargetSumDpBottomUp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfDiceRollsWithTargetSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 6, 3, 1),
            Arguments.of(2, 6, 7, 6),
            Arguments.of(30, 30, 500, 222616187)
        )
    }


    @Nested
    inner class NumberOfDiceRollsWithTargetSumDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible ways to roll the dice so the sum of the face-up numbers equals target`(
            n: Int,
            k: Int,
            target: Int,
            expected: Int
        ) {
            NumberOfDiceRollsWithTargetSumDPTopDown().test(n, k, target, expected)
        }
    }

    @Nested
    inner class NumberOfDiceRollsWithTargetSumDpBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible ways to roll the dice so the sum of the face-up numbers equals target`(
            n: Int,
            k: Int,
            target: Int,
            expected: Int
        ) {
            NumberOfDiceRollsWithTargetSumDpBottomUp().test(n, k, target, expected)
        }
    }

    private fun NumberOfDiceRollsWithTargetSum.test(n: Int, k: Int, target: Int, expected: Int) {
        val actual = numRollsToTarget(n, k, target)
        assertEquals(expected, actual)
    }
}