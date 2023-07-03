package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BuddyStrings.BuddyStringsRev1
import com.github.dkoval.leetcode.challenge.BuddyStrings.BuddyStringsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BuddyStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("ab", "ba", true),
            Arguments.of("ab", "ab", false),
            Arguments.of("aa", "aa", true),
            Arguments.of("ab", "babbb", false),
            Arguments.of("aaaaaaabc", "aaaaaaacb", true),
            Arguments.of("", "aa", false)
        )
    }

    @Nested
    inner class BuddyStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can swap two letters in s so the result is equal to goal`(
            s: String,
            goal: String,
            expected: Boolean
        ) {
            BuddyStringsRev1().test(s, goal, expected)
        }
    }

    @Nested
    inner class BuddyStringsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can swap two letters in s so the result is equal to goal`(
            s: String,
            goal: String,
            expected: Boolean
        ) {
            BuddyStringsRev2().test(s, goal, expected)
        }
    }
}

private fun BuddyStrings.test(s: String, goal: String, expected: Boolean) {
    val actual = buddyStrings(s, goal)
    assertEquals(expected, actual)
}
