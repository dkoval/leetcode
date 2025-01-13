package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumLengthOfStringAfterOperations.MinimumLengthOfStringAfterOperationsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumLengthOfStringAfterOperationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abaacbcbb",
                5
            ),
            Arguments.of(
                "aa",
                2
            )
        )
    }

    @Nested
    inner class MinimumLengthOfStringAfterOperationsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum length of the final string s that you can achieve`(s: String, expected: Int) {
            MinimumLengthOfStringAfterOperationsRev1().test(s, expected)
        }
    }
}

private fun MinimumLengthOfStringAfterOperations.test(s: String, expected: Int) {
    val actual = minimumLength(s)
    assertEquals(expected, actual)
}
