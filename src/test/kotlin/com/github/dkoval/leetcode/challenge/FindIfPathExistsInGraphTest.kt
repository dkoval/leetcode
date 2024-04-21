package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindIfPathExistsInGraph.FindIfPathExistsInGraphBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindIfPathExistsInGraphTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 0)
                ),
                0,
                2,
                true
            ),
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(3, 5),
                    intArrayOf(5, 4),
                    intArrayOf(4, 3)
                ),
                0,
                5,
                false
            )
        )
    }

    @Nested
    inner class FindIfPathExistsInGraphBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if there is a valid path from source to destination, or false otherwise`(
            n: Int,
            edges: Array<IntArray>,
            source: Int,
            destination: Int,
            expected: Boolean
        ) {
            FindIfPathExistsInGraphBFS().test(n, edges, source, destination, expected)
        }
    }
}

private fun FindIfPathExistsInGraph.test(
    n: Int,
    edges: Array<IntArray>,
    source: Int,
    destination: Int,
    expected: Boolean
) {
    val actual = validPath(n, edges, source, destination)
    assertEquals(expected, actual)
}
