package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfGridCanBeCutIntoSections.CheckIfGridCanBeCutIntoSectionsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfGridCanBeCutIntoSectionsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(contex: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(1, 0, 5, 2),
                    intArrayOf(0, 2, 2, 4),
                    intArrayOf(3, 2, 5, 3),
                    intArrayOf(0, 4, 4, 5)
                ),
                true
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(2, 0, 3, 4),
                    intArrayOf(0, 2, 2, 3),
                    intArrayOf(3, 0, 4, 3)
                ),
                true
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 2, 2, 4),
                    intArrayOf(1, 0, 3, 2),
                    intArrayOf(2, 2, 3, 4),
                    intArrayOf(3, 0, 4, 2),
                    intArrayOf(3, 2, 4, 4)
                ),
                false
            )
        )
    }

    @Nested
    inner class CheckIfGridCanBeCutIntoSectionsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the grid can be cut into sections`(
            n: Int,
            grid: Array<IntArray>,
            expected: Boolean
        ) {
            CheckIfGridCanBeCutIntoSectionsRev1().test(n, grid, expected)
        }
    }
}

private fun CheckIfGridCanBeCutIntoSections.test(n: Int, grid: Array<IntArray>, expected: Boolean) {
    val actual = checkValidCuts(n, grid)
    assertEquals(expected, actual)
}
