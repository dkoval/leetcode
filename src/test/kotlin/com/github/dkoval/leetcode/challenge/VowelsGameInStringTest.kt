package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.VowelsGameInString.VowelsGameInStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class VowelsGameInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("leetcoder", true),
            Arguments.of("bbcd", false)
        )
    }

    @Nested
    inner class VowelsGameInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if Alice wins the game`(s: String, expected: Boolean) {
            VowelsGameInStringRev1().test(s, expected)
        }
    }
}

private fun VowelsGameInString.test(s: String, expected: Boolean) {
    val actual = doesAliceWin(s)
    assertEquals(expected, actual)
}
