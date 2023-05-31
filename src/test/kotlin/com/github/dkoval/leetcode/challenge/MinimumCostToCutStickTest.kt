package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostToCutStick.MinimumCostToCutStickDPTopDownRev1
import com.github.dkoval.leetcode.challenge.MinimumCostToCutStick.MinimumCostToCutStickDPTopDownRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumCostToCutStickTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7,
                intArrayOf(1, 3, 4, 5),
                16
            ),
            Arguments.of(
                9,
                intArrayOf(5, 6, 1, 4, 2),
                22
            )
        )
    }

    @Nested
    inner class MinimumCostToCutStickDPTopDownRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum total cost of the cuts`(n: Int, cuts: IntArray, expected: Int) {
            MinimumCostToCutStickDPTopDownRev1().test(n, cuts, expected)
        }
    }

    @Nested
    inner class MinimumCostToCutStickDPTopDownRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum total cost of the cuts`(n: Int, cuts: IntArray, expected: Int) {
            MinimumCostToCutStickDPTopDownRev2().test(n, cuts, expected)
        }
    }
}

private fun MinimumCostToCutStick.test(n: Int, cuts: IntArray, expected: Int) {
    val actual = minCost(n, cuts)
    assertEquals(expected, actual)
}
