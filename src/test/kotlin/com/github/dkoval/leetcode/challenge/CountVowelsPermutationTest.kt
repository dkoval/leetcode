package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountVowelsPermutation.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class CountVowelsPermutationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 5),
            Arguments.of(2, 10),
            Arguments.of(5, 68)
        )
    }

    @Nested
    inner class CountVowelsPermutationDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count how many strings of length n can be formed following rules`(n: Int, expected: Int) {
            CountVowelsPermutationDPTopDown().test(n, expected)
        }
    }

    @Nested
    inner class CountVowelsPermutationDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count how many strings of length n can be formed following rules`(n: Int, expected: Int) {
            CountVowelsPermutationDPBottomUp().test(n, expected)
        }
    }

    @Nested
    inner class CountVowelsPermutationDPBottomUpSpaceOptimizedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count how many strings of length n can be formed following rules`(n: Int, expected: Int) {
            CountVowelsPermutationDPBottomUpSpaceOptimized().test(n, expected)
        }
    }
}

private fun CountVowelsPermutation.test(n: Int, expected: Int) {
    val actual = countVowelPermutation(n)
    assertEquals(expected, actual)
}
