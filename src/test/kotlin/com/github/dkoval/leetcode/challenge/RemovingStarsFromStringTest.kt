package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemovingStarsFromString.RemovingStarsFromStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemovingStarsFromStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "leet**cod*e",
                "lecoe"
            ),
            Arguments.of(
                "erase*****",
                ""
            )
        )
    }

    @Nested
    inner class RemovingStarsFromStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the string after all stars have been removed`(s: String, expected: String) {
            RemovingStarsFromStringRev1().test(s, expected)
        }
    }
}

private fun RemovingStarsFromString.test(s: String, expected: String) {
    val actual = removeStars(s)
    assertEquals(expected, actual)
}
