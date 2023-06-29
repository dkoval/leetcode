package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestPathToGetAllKeys.ShortestPathToGetAllKeysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestPathToGetAllKeysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("@.a..", "###.#", "b.A.B"),
                8
            ),
            Arguments.of(
                arrayOf("@..aA", "..B#.", "....b"),
                6
            ),
            Arguments.of(
                arrayOf("@Aa"),
                -1
            ),
            Arguments.of(
                arrayOf("@abcdeABCDEFf"),
                -1
            )
        )
    }

    @Nested
    inner class ShortestPathToGetAllKeysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lowest number of moves to acquire all keys`(grid: Array<String>, expected: Int) {
            ShortestPathToGetAllKeysRev1().test(grid, expected)
        }
    }
}

private fun ShortestPathToGetAllKeys.test(grid: Array<String>, expected: Int) {
    val actual = shortestPathAllKeys(grid)
    assertEquals(expected, actual)
}
