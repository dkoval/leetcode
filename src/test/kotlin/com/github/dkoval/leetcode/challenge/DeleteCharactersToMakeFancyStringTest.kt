package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DeleteCharactersToMakeFancyString.DeleteCharactersToMakeFancyStringRev1
import com.github.dkoval.leetcode.challenge.DeleteCharactersToMakeFancyString.DeleteCharactersToMakeFancyStringRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteCharactersToMakeFancyStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("leeetcode", "leetcode"),
            Arguments.of("aaabaaaa", "aabaa"),
            Arguments.of("aab", "aab")
        )
    }

    @Nested
    inner class DeleteCharactersToMakeFancyStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final string after the deletion`(s: String, expected: String) {
            DeleteCharactersToMakeFancyStringRev1().test(s, expected)
        }
    }

    @Nested
    inner class DeleteCharactersToMakeFancyStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final string after the deletion`(s: String, expected: String) {
            DeleteCharactersToMakeFancyStringRev2().test(s, expected)
        }
    }
}

private fun DeleteCharactersToMakeFancyString.test(s: String, expected: String) {
    val actual = makeFancyString(s)
    assertEquals(expected, actual)
}
