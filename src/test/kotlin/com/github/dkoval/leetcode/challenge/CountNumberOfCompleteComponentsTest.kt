package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfCompleteComponents.CountNumberOfCompleteComponentsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfCompleteComponentsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                ),
                3
            ),
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(3, 5)
                ),
                1
            )
        )
    }

    @Nested
    inner class CountNumberOfCompleteComponentsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of complete connected components of the graph`(
            n: Int,
            edges: Array<IntArray>,
            expected: Int
        ) {
            CountNumberOfCompleteComponentsRev1().test(n, edges, expected)
        }
    }
}

private fun CountNumberOfCompleteComponents.test(n: Int, edges: Array<IntArray>, expected: Int) {
    val actual = countCompleteComponents(n, edges)
    assertEquals(expected, actual)
}
