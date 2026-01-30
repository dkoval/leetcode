package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCostToConvertString2.MinimumCostToConvertString2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MinimumCostToConvertString2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                "abcd",
                "acbe",
                arrayOf("a", "b", "c", "c", "e", "d"),
                arrayOf("b", "c", "b", "e", "b", "e"),
                intArrayOf(2, 5, 5, 1, 2, 20),
                28L
            ),
            arguments(
                "abcdefgh",
                "acdeeghh",
                arrayOf("bcd", "fgh", "thh"),
                arrayOf("cde", "thh", "ghh"),
                intArrayOf(1, 3, 5),
                9L
            ),
            arguments(
                "abcdefgh",
                "addddddd",
                arrayOf("bcd", "defgh"),
                arrayOf("ddd", "ddddd"),
                intArrayOf(100, 1578),
                -1L
            )
        )
    }

    @Nested
    inner class MinimumCostToConvertString2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to convert the string source to the string target using any number of operations`(
            source: String,
            target: String,
            original: Array<String>,
            changed: Array<String>,
            costs: IntArray,
            expected: Long
        ) {
            MinimumCostToConvertString2Rev1().test(source, target, original, changed, costs, expected)
        }
    }
}

private fun MinimumCostToConvertString2.test(
    source: String,
    target: String,
    original: Array<String>,
    changed: Array<String>,
    costs: IntArray,
    expected: Long
) {
    val actual = minimumCost(source, target, original, changed, costs)
    assertEquals(expected, actual)
}
