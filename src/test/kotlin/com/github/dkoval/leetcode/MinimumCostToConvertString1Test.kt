package com.github.dkoval.leetcode

import com.github.dkoval.leetcode.challenge.MinimumCostToConvertString1
import com.github.dkoval.leetcode.challenge.MinimumCostToConvertString1.MinimumCostToConvertString1Rev1
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

internal class MinimumCostToConvertString1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                "abcd",
                "acbe",
                charArrayOf('a', 'b', 'c', 'c', 'e', 'd'),
                charArrayOf('b', 'c', 'b', 'e', 'b', 'e'),
                intArrayOf(2, 5, 5, 1, 2, 20),
                28L
            ),
            arguments(
                "aaaa",
                "bbbb",
                charArrayOf('a', 'c'),
                charArrayOf('c', 'b'),
                intArrayOf(1, 2),
                12L
            ),
            arguments(
                "abcd",
                "abce",
                charArrayOf('a'),
                charArrayOf('e'),
                intArrayOf(10000),
                -1L
            ),
            arguments(
                "aabbddccbc",
                "abbbaabaca",
                charArrayOf('a', 'b', 'c', 'b', 'a', 'd'),
                charArrayOf('d', 'c', 'b', 'd', 'b', 'b'),
                intArrayOf(3, 8, 7, 6, 7, 10),
                -1L
            )
        )
    }

    @Nested
    inner class MinimumCostToConvertString1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost to convert the string source to the string target using any number of operations`(
            source: String,
            target: String,
            original: CharArray,
            changed: CharArray,
            costs: IntArray,
            expected: Long
        ) {
            MinimumCostToConvertString1Rev1().test(source, target, original, changed, costs, expected)
        }
    }
}

private fun MinimumCostToConvertString1.test(
    source: String,
    target: String,
    original: CharArray,
    changed: CharArray,
    costs: IntArray,
    expected: Long
) {
    val actual = minimumCost(source, target, original, changed, costs)
    assertEquals(expected, actual)
}
