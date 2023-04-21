package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ProfitableSchemes.ProfitableSchemesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ProfitableSchemesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5, 3, intArrayOf(2, 2), intArrayOf(2, 3), 2
            ),
            Arguments.of(
                10, 5, intArrayOf(2, 3, 5), intArrayOf(6, 7, 8), 7
            )
        )
    }

    @Nested
    inner class ProfitableSchemesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of schemes that can be chosen`(
            n: Int,
            minProfit: Int,
            group: IntArray,
            profit: IntArray,
            expected: Int
        ) {
            ProfitableSchemesRev1().test(n, minProfit, group, profit, expected)
        }
    }
}

private fun ProfitableSchemes.test(n: Int, minProfit: Int, group: IntArray, profit: IntArray, expected: Int) {
    val actual = profitableSchemes(n, minProfit, group, profit)
    assertEquals(expected, actual)
}
