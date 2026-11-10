package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ClimbingStairs2.ClimbingStairs2Rev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ClimbingStairs2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                4,
                intArrayOf(1, 2, 3, 4),
                13
            ),
            arguments(
                4,
                intArrayOf(5, 1, 6, 2),
                11
            ),
            arguments(
                3,
                intArrayOf(9, 8, 3),
                12
            )
        )
    }

    @Nested
    inner class ClimbingStairs2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum total cost to reach step n`(n: Int, costs: IntArray, expected: Int) {
            ClimbingStairs2Rev1().test(n, costs, expected)
        }
    }
}

private fun ClimbingStairs2Rev1.test(n: Int, costs: IntArray, expected: Int) {
    val actual = climbStairs(n, costs)
    assertThat(actual).isEqualTo(expected)
}
