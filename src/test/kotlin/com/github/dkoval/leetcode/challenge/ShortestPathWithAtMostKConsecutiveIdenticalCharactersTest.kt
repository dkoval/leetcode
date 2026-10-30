package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestPathWithAtMostKConsecutiveIdenticalCharacters.ShortestPathWithAtMostKConsecutiveIdenticalCharactersRev1
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

internal class ShortestPathWithAtMostKConsecutiveIdenticalCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                3,
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(0, 2, 3)
                ),
                "aab",
                1,
                3
            ),
            arguments(
                3,
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1),
                    intArrayOf(0, 2, 3)
                ),
                "aab",
                2,
                2
            ),
            arguments(
                3,
                arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(1, 2, 1)
                ),
                "aaa",
                2,
                -1
            )
        )
    }

    @Nested
    inner class ShortestPathWithAtMostKConsecutiveIdenticalCharactersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum total edge weight of a path from node 0 to node n - 1 such that the concatenation of the labels of the nodes along the path contains at most k consecutive identical characters`(
            n: Int,
            edges: Array<IntArray>,
            labels: String,
            k: Int,
            expected: Int
        ) {
            ShortestPathWithAtMostKConsecutiveIdenticalCharactersRev1().test(n, edges, labels, k, expected)
        }
    }
}

private fun ShortestPathWithAtMostKConsecutiveIdenticalCharactersRev1.test(
    n: Int,
    edges: Array<IntArray>,
    labels: String,
    k: Int,
    expected: Int
) {
    val actual = shortestPath(n, edges, labels, k)
    assertThat(expected).isEqualTo(actual)
}
