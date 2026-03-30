package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfStringsCanBeMadeEqualWithOperations2.CheckIfStringsCanBeMadeEqualWithOperations2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CheckIfStringsCanBeMadeEqualWithOperations2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abcdba",
                "cabdab",
                true
            ),
            Arguments.of(
                "abe",
                "bea",
                false
            )
        )
    }

    @Nested
    inner class CheckIfStringsCanBeMadeEqualWithOperations2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can make the strings s1 and s2 equal`(s1: String, s2: String, expected: Boolean) {
            CheckIfStringsCanBeMadeEqualWithOperations2Rev1().test(s1, s2, expected)
        }
    }
}

private fun CheckIfStringsCanBeMadeEqualWithOperations2.test(s1: String, s2: String, expected: Boolean) {
    val actual = checkStrings(s1, s2)
    assertEquals(expected, actual)
}
