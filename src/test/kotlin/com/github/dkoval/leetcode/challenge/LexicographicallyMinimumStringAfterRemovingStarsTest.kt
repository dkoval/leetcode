package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LexicographicallyMinimumStringAfterRemovingStars.LexicographicallyMinimumStringAfterRemovingStarsRev1
import com.github.dkoval.leetcode.challenge.LexicographicallyMinimumStringAfterRemovingStars.LexicographicallyMinimumStringAfterRemovingStarsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LexicographicallyMinimumStringAfterRemovingStarsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("aaba*", "aab"),
            Arguments.of("abc", "abc")
        )
    }

    @Nested
    inner class LexicographicallyMinimumStringAfterRemovingStarsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest resulting string after removing all 'star' characters`(
            s: String,
            expected: String
        ) {
            LexicographicallyMinimumStringAfterRemovingStarsRev1().test(s, expected)
        }
    }

    @Nested
    inner class LexicographicallyMinimumStringAfterRemovingStarsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest resulting string after removing all 'star' characters`(
            s: String,
            expected: String
        ) {
            LexicographicallyMinimumStringAfterRemovingStarsRev2().test(s, expected)
        }
    }
}

private fun LexicographicallyMinimumStringAfterRemovingStars.test(s: String, expected: String) {
    val actual = clearStars(s)
    assertEquals(expected, actual)
}
