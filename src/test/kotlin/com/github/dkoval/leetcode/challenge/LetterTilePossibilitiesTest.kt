package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LetterTilePossibilities.LetterTilePossibilitiesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LetterTilePossibilitiesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "AAB",
                8
            ),
            Arguments.of(
                "AAABBC",
                188
            )
        )
    }

    @Nested
    inner class LetterTilePossibilitiesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible non-empty sequences of letters you can make`(
            tiles: String,
            expected: Int
        ) {
            LetterTilePossibilitiesRev1().test(tiles, expected)
        }
    }
}

private fun LetterTilePossibilities.test(tiles: String, expected: Int) {
    val actual = numTilePossibilities(tiles)
    assertEquals(expected, actual)
}
