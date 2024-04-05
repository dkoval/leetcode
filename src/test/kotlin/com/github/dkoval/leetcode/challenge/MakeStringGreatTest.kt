package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MakeStringGreat.MakeStringGreatRev1
import com.github.dkoval.leetcode.challenge.MakeStringGreat.MakeStringGreatRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MakeStringGreatTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("leEeetcode", "leetcode"),
            Arguments.of("abBAcC", ""),
            Arguments.of("s", "s"),
            Arguments.of("Pp", "")
        )
    }

    @Nested
    inner class MakeStringGreatRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should make the string great`(s: String, expected: String) {
            MakeStringGreatRev1().test(s, expected)
        }
    }

    @Nested
    inner class MakeStringGreatRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should make the string great`(s: String, expected: String) {
            MakeStringGreatRev2().test(s, expected)
        }
    }
}

private fun MakeStringGreat.test(s: String, expected: String) {
    val actual = makeGood(s)
    assertEquals(expected, actual)
}
