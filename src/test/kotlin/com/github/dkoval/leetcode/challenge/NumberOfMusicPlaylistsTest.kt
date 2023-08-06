package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfMusicPlaylists.NumberOfMusicPlaylistsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfMusicPlaylistsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 3, 1, 6),
            Arguments.of(2, 3, 0, 6),
            Arguments.of(2, 3, 1, 2),
            Arguments.of(1, 3, 0, 1),
            Arguments.of(16, 16, 4, 789741546)
        )
    }

    @Nested
    inner class NumberOfMusicPlaylistsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible playlists that you can create`(
            n: Int,
            goal: Int,
            k: Int,
            expected: Int
        ) {
            NumberOfMusicPlaylistsDPTopDown().test(n, goal, k, expected)
        }
    }
}

private fun NumberOfMusicPlaylists.test(n: Int, goal: Int, k: Int, expected: Int) {
    val actual = numMusicPlaylists(n, goal, k)
    assertEquals(expected, actual)
}
