package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RedistributeCharactersToMakeAllStringsEqual.RedistributeCharactersToMakeAllStringsEqualRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RedistributeCharactersToMakeAllStringsEqualTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("abc", "aabc", "bc"),
                true
            ),
            Arguments.of(
                arrayOf("ab", "a"),
                false
            ),
            Arguments.of(
                arrayOf("abbab"),
                true
            ),
            Arguments.of(
                arrayOf(
                    "caaaaa",
                    "aaaaaaaaa",
                    "a",
                    "bbb",
                    "bbbbbbbbb",
                    "bbb",
                    "cc",
                    "cccccccccccc",
                    "ccccccc",
                    "ccccccc",
                    "cc",
                    "cccc",
                    "c",
                    "cccccccc",
                    "c"
                ),
                true
            ),
            Arguments.of(
                arrayOf("aa", "abaab"),
                false
            )
        )
    }

    @Nested
    inner class RedistributeCharactersToMakeAllStringsEqualRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can make every string in words equal using any number of operations, and false otherwise`(
            words: Array<String>,
            expected: Boolean
        ) {
            RedistributeCharactersToMakeAllStringsEqualRev1().test(words, expected)
        }
    }
}

private fun RedistributeCharactersToMakeAllStringsEqual.test(words: Array<String>, expected: Boolean) {
    val actual = makeEqual(words)
    assertEquals(expected, actual)
}
