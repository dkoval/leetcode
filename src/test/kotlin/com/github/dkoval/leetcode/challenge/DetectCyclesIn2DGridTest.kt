package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DetectCyclesIn2DGrid.DetectCyclesIn2DGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class DetectCyclesIn2DGridTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('a', 'a', 'a', 'a'),
                    charArrayOf('a', 'b', 'b', 'a'),
                    charArrayOf('a', 'b', 'b', 'a'),
                    charArrayOf('a', 'a', 'a', 'a')
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('c', 'c', 'c', 'a'),
                    charArrayOf('c', 'd', 'c', 'c'),
                    charArrayOf('c', 'c', 'e', 'c'),
                    charArrayOf('f', 'c', 'c', 'c')
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('a', 'b', 'b'),
                    charArrayOf('b', 'z', 'b'),
                    charArrayOf('b', 'b', 'a')
                ),
                false
            )
        )
    }

    @Nested
    inner class DetectCyclesIn2DGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if there is a cycle in 2D grid`(grid: Array<CharArray>, expected: Boolean) {
            DetectCyclesIn2DGridRev1().test(grid, expected)
        }
    }
}

private fun DetectCyclesIn2DGrid.test(grid: Array<CharArray>, expected: Boolean) {
    val actual = containsCycle(grid)
    assertEquals(expected, actual)
}
