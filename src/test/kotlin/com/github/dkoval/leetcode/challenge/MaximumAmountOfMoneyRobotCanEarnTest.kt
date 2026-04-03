package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumAmountOfMoneyRobotCanEarn.MaximumAmountOfMoneyRobotCanEarnRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumAmountOfMoneyRobotCanEarnTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, -1),
                    intArrayOf(1, -2, 3),
                    intArrayOf(2, -3, 4)
                ),
                8
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(10, 10, 10),
                    intArrayOf(10, 10, 10)
                ),
                40
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(-16, 4, 1, -1),
                    intArrayOf(11, 9, 3, 3),
                    intArrayOf(-6, 17, -19, 9),
                    intArrayOf(14, -17, -19, -13)
                ),
                35
            )
        )
    }

    @Nested
    inner class MaximumAmountOfMoneyRobotCanEarnRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum amount of money the robot can earn`(coins: Array<IntArray>, expected: Int) {
            MaximumAmountOfMoneyRobotCanEarnRev1().test(coins, expected)
        }
    }
}

private fun MaximumAmountOfMoneyRobotCanEarn.test(coins: Array<IntArray>, expected: Int) {
    val actual = maximumAmount(coins)
    assertEquals(expected, actual)
}
