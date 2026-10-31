package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TwistedMirrorPathCount.TwistedMirrorPathCountRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class TwistedMirrorPathCountTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 0, 0)
                ),
                5
            ),
            arguments(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 0)
                ),
                2
            ),
            arguments(
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 1, 0)
                ),
                1
            )
        )
    }

    @Nested
    inner class TwistedMirrorPathCountRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique valid paths from (0, 0) to (m - 1, n - 1)`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            TwistedMirrorPathCountRev1().test(grid, expected)
        }
    }
}

private fun TwistedMirrorPathCount.test(grid: Array<IntArray>, expected: Int) {
    val actual = uniquePaths(grid)
    assertThat(actual).isEqualTo(expected)
}
