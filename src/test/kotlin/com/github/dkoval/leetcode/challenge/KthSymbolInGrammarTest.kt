package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthSymbolInGrammar.KthSymbolInGrammarRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KthSymbolInGrammarTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1, 0),
            Arguments.of(2, 1, 0),
            Arguments.of(2, 2, 1),
            Arguments.of(3, 4, 0)
        )
    }

    @Nested
    inner class KthSymbolInGrammarRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the kth (1-indexed) symbol in the n-th row of a table of n rows`(
            n: Int,
            k: Int,
            expected: Int
        ) {
            KthSymbolInGrammarRev1().test(n, k, expected)
        }
    }
}

private fun KthSymbolInGrammar.test(n: Int, k: Int, expected: Int) {
    val actual = kthGrammar(n, k)
    assertEquals(expected, actual)
}
