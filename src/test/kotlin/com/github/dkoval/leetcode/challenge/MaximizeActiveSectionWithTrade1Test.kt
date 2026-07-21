package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximizeActiveSectionWithTrade1.MaximizeActiveSectionWithTrade1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximizeActiveSectionWithTrade1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("01", 1),
            Arguments.of("0100", 4),
            Arguments.of("1000100", 7),
            Arguments.of("01010", 4)
        )
    }

    @Nested
    inner class MaximizeActiveSectionWithTrade1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of active sections in s after making the optimal trade`(
            s: String,
            expected: Int
        ) {
            MaximizeActiveSectionWithTrade1Rev1().test(s, expected)
        }
    }
}

private fun MaximizeActiveSectionWithTrade1Rev1.test(s: String, expected: Int) {
    val actual = maxActiveSectionsAfterTrade(s)
    assertEquals(expected, actual)
}
