package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfPushesToTypeWord1.MinimumNumberOfPushesToTypeWord1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MinimumNumberOfPushesToTypeWord1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("abcde", 5),
            Arguments.of("xycdefghij", 12)
        )
    }

    @Nested
    inner class MinimumNumberOfPushesToTypeWord1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the minimum number of pushes needed to type word after remapping the keys`(
            word: String,
            expected: Int
        ) {
            MinimumNumberOfPushesToTypeWord1Rev1().test(word, expected)
        }
    }
}

private fun MinimumNumberOfPushesToTypeWord1.test(word: String, expected: Int) {
    val actual = minimumPushes(word)
    assertEquals(expected, actual)
}
