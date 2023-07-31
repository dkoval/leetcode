package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumASCIIDeleteSumForTwoStrings.MinimumASCIIDeleteSumForTwoStringsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumASCIIDeleteSumForTwoStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "sea",
                "eat",
                231
            ),
            Arguments.of(
                "delete",
                "leet",
                403
            )
        )
    }

    @Nested
    inner class MinimumASCIIDeleteSumForTwoStringsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lowest ASCII sum of deleted characters to make two strings equal`(
            s1: String,
            s2: String,
            expected: Int
        ) {
            MinimumASCIIDeleteSumForTwoStringsDPTopDown().test(s1, s2, expected)
        }
    }
}

private fun MinimumASCIIDeleteSumForTwoStrings.test(s1: String, s2: String, expected: Int) {
    val actual = minimumDeleteSum(s1, s2)
    assertEquals(expected, actual)
}
