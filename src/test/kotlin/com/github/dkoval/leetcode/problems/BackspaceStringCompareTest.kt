package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.BackspaceStringCompare.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BackspaceStringCompareTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("ab#c", "ad#c", true),
            Arguments.of("ab##", "c#d#", true),
            Arguments.of("a##c", "#a#c", true),
            Arguments.of("a#c", "b", false)
        )
    }

    @Nested
    inner class BackspaceStringCompareUsingStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if both strings s and t are equal  after removing backspace characters`(
            s: String,
            t: String,
            expected: Boolean
        ) {
            BackspaceStringCompareUsingStack().test(s, t, expected)
        }
    }

    @Nested
    inner class BackspaceStringCompareUsingStringBuilderTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if both strings s and t are equal  after removing backspace characters`(
            s: String,
            t: String,
            expected: Boolean
        ) {
            BackspaceStringCompareUsingStringBuilder().test(s, t, expected)
        }
    }

    @Nested
    inner class BackspaceStringCompareUsingTwoPointersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if both strings s and t are equal  after removing backspace characters`(
            s: String,
            t: String,
            expected: Boolean
        ) {
            BackspaceStringCompareUsingTwoPointersRev1().test(s, t, expected)
        }
    }

    @Nested
    inner class BackspaceStringCompareUsingTwoPointersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if both strings s and t are equal  after removing backspace characters`(
            s: String,
            t: String,
            expected: Boolean
        ) {
            BackspaceStringCompareUsingTwoPointersRev2().test(s, t, expected)
        }
    }
}

private fun BackspaceStringCompare.test(s: String, t: String, expected: Boolean) {
    val actual = backspaceCompare(s, t)
    assertEquals(expected, actual)
}
