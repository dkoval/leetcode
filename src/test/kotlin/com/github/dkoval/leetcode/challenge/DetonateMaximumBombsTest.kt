package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DetonateMaximumBombs.DetonateMaximumBombsDFSRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DetonateMaximumBombsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1, 3),
                    intArrayOf(6, 1, 4)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 5),
                    intArrayOf(10, 10, 5)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 1),
                    intArrayOf(3, 4, 2),
                    intArrayOf(4, 5, 3),
                    intArrayOf(5, 6, 4),
                ),
                5
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(4, 4, 3),
                    intArrayOf(4, 4, 3)
                ),
                2
            )
        )
    }

    @Nested
    inner class DetonateMaximumBombsDFSRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb`(
            bombs: Array<IntArray>,
            expected: Int
        ) {
            DetonateMaximumBombsDFSRev1().test(bombs, expected)
        }
    }
}

private fun DetonateMaximumBombs.test(bombs: Array<IntArray>, expected: Int) {
    val actual = maximumDetonation(bombs)
    assertEquals(expected, actual)
}
