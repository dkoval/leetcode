package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfAllAsAppearsBeforeAllBs.CheckIfAllAsAppearsBeforeAllBsRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CheckIfAllAsAppearsBeforeAllBsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments("aaabbb", true),
            arguments("abab", false),
            arguments("bbb", true)
        )
    }

    @Nested
    inner class CheckIfAllAsAppearsBeforeAllBsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if every 'a' appears before every 'b' in the string`(s: String, expected: Boolean) {
            CheckIfAllAsAppearsBeforeAllBsRev1().test(s, expected)
        }
    }
}

private fun CheckIfAllAsAppearsBeforeAllBsRev1.test(s: String, expected: Boolean) {
    val actual = checkString(s)
    assertThat(actual).isEqualTo(expected)
}
