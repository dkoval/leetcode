package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfWaysOfCuttingPizza.NumberOfWaysOfCuttingPizzaDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfWaysOfCuttingPizzaTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("A..", "AAA", "..."),
                3,
                3
            ),
            Arguments.of(
                arrayOf("A..", "AA.", "..."),
                3,
                1
            ),
            Arguments.of(
                arrayOf("A..", "A..", "..."),
                1,
                1
            ),
            Arguments.of(
                arrayOf(".A..A", "A.A..", "A.AA.", "AAAA.", "A.AA."),
                5,
                153
            )
        )
    }

    @Nested
    inner class NumberOfWaysOfCuttingPizzaDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of ways of cutting the pizza such that each piece contains at least one apple`(
            pizza: Array<String>,
            k: Int,
            expected: Int
        ) {
            NumberOfWaysOfCuttingPizzaDPTopDown().test(pizza, k, expected)
        }
    }
}

private fun NumberOfWaysOfCuttingPizzaDPTopDown.test(
    pizza: Array<String>,
    k: Int,
    expected: Int
) {
    val actual = ways(pizza, k)
    assertEquals(expected, actual)
}
