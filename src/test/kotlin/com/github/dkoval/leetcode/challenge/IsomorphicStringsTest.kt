package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IsomorphicStrings.IsomorphicStringsRev1
import com.github.dkoval.leetcode.challenge.IsomorphicStrings.IsomorphicStringsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IsomorphicStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "egg",
                "add",
                true
            ),
            Arguments.of(
                "foo",
                "bar",
                false
            ),
            Arguments.of(
                "paper",
                "title",
                true
            ),
            Arguments.of(
                "abcd",
                "abae",
                false
            )
        )
    }

    @Nested
    inner class IsomorphicStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine of two strings are isomorphic`(s: String, t: String, expected: Boolean) {
            IsomorphicStringsRev1().test(s, t, expected)
        }
    }

    @Nested
    inner class IsomorphicStringsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine of two strings are isomorphic`(s: String, t: String, expected: Boolean) {
            IsomorphicStringsRev2().test(s, t, expected)
        }
    }
}

private fun IsomorphicStrings.test(s: String, t: String, expected: Boolean) {
    val actual = isIsomorphic(s, t)
    assertEquals(expected, actual)
}
