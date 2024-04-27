package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumHeightTrees.MinimumHeightTreesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumHeightTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3)
                ),
                listOf(1)
            ),
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(3, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2),
                    intArrayOf(3, 4),
                    intArrayOf(5, 4)
                ),
                listOf(3, 4)
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2)
                ),
                listOf(0)
            ),
            Arguments.of(
                1,
                arrayOf<IntArray>(),
                listOf(0)
            ),
        )
    }

    @Nested
    inner class MinimumHeightTreesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all MHTs' root labels`(n: Int, edges: Array<IntArray>, expected: List<Int>) {
            MinimumHeightTreesRev1().test(n, edges, expected)
        }
    }
}

private fun MinimumHeightTrees.test(n: Int, edges: Array<IntArray>, expected: List<Int>) {
    val actual = findMinHeightTrees(n, edges)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
