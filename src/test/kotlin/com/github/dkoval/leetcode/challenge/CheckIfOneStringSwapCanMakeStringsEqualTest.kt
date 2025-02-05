package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfOneStringSwapCanMakeStringsEqual.CheckIfOneStringSwapCanMakeStringsEqualRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfOneStringSwapCanMakeStringsEqualTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "bank",
                "kanb",
                true
            ),
            Arguments.of(
                "attack",
                "defend",
                false
            ),
            Arguments.of(
                "kelb",
                "kelb",
                true
            ),
            Arguments.of(
                "aa",
                "ac",
                false
            ),
            Arguments.of(
                "abcd",
                "dcba",
                false
            )
        )
    }

    @Nested
    inner class CheckIfOneStringSwapCanMakeStringsEqualRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `check if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings`(
            s1: String,
            s2: String,
            expected: Boolean
        ) {
            CheckIfOneStringSwapCanMakeStringsEqualRev1().test(s1, s2, expected)
        }
    }
}

private fun CheckIfOneStringSwapCanMakeStringsEqual.test(s1: String, s2: String, expected: Boolean) {
    val actual = areAlmostEqual(s1, s2)
    assertEquals(expected, actual)
}
