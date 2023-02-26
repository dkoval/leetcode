package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class EditDistanceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            /*
            horse -> rorse (replace 'h' with 'r')
            rorse -> rose (remove 'r')
            rose -> ros (remove 'e')
            */
            Arguments.of("horse", "ros", 3),
            /*
            intention -> inention (remove 't')
            inention -> enention (replace 'i' with 'e')
            enention -> exention (replace 'n' with 'x')
            exention -> exection (replace 'n' with 'c')
            exection -> execution (insert 'u')
            */
            Arguments.of("intention", "execution", 5),
            Arguments.of("", "a", 1)
        )
    }

    @Nested
    inner class EditDistanceDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum number of operations required to convert word1 to word2`(
            word1: String,
            word2: String,
            expected: Int
        ) {
            EditDistanceDPTopDown().test(word1, word2, expected)
        }
    }

    @Nested
    inner class EditDistanceDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum number of operations required to convert word1 to word2`(
            word1: String,
            word2: String,
            expected: Int
        ) {
            EditDistanceDPBottomUp.test(word1, word2, expected)
        }
    }
}

private fun EditDistance.test(word1: String, word2: String, expected: Int) {
    val actual = minDistance(word1, word2)
    assertEquals(expected, actual)
}
