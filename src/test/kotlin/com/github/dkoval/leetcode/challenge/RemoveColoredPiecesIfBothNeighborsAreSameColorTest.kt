package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveColoredPiecesIfBothNeighborsAreSameColor.RemoveColoredPiecesIfBothNeighborsAreSameColorRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveColoredPiecesIfBothNeighborsAreSameColorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("AAABABB", true),
            Arguments.of("AA", false),
            Arguments.of("ABBBBBBBAAA", false)
        )
    }

    @Nested
    inner class RemoveColoredPiecesIfBothNeighborsAreSameColorRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if Alice wins, or return false if Bob wins`(colors: String, expected: Boolean) {
            RemoveColoredPiecesIfBothNeighborsAreSameColorRev1().test(colors, expected)
        }
    }
}

private fun RemoveColoredPiecesIfBothNeighborsAreSameColor.test(colors: String, expected: Boolean) {
    val actual = winnerOfGame(colors)
    assertEquals(expected, actual)
}
