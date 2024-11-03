package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RotateString.RotateStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RotateStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcde", "cdeab", true),
            Arguments.of("abcde", "abced", false)
        )
    }

    @Nested
    inner class RotateStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if s can become goal after some number of shifts on s`(
            s: String,
            goal: String,
            expected: Boolean
        ) {
            RotateStringRev1().test(s, goal, expected)
        }
    }
}

private fun RotateString.test(s: String, goal: String, expected: Boolean) {
    val actual = rotateString(s, goal)
    assertEquals(expected, actual)
}
