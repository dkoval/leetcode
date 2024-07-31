package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FillingBookcaseShelves.FillingBookcaseShelvesDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FillingBookcaseShelvesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 3),
                    intArrayOf(2, 3),
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                    intArrayOf(1, 2),
                ),
                4,
                6
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 4),
                    intArrayOf(3, 2)
                ),
                6,
                4
            )
        )
    }

    @Nested
    inner class FillingBookcaseShelvesDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible height that the total bookshelf can be after placing shelves in this manner`(
            books: Array<IntArray>,
            shelfWidth: Int,
            expected: Int
        ) {
            FillingBookcaseShelvesDPTopDown().test(books, shelfWidth, expected)
        }
    }
}

private fun FillingBookcaseShelves.test(books: Array<IntArray>, shelfWidth: Int, expected: Int) {
    val actual = minHeightShelves(books, shelfWidth)
    assertEquals(expected, actual)
}
