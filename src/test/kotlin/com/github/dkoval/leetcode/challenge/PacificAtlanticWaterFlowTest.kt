package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PacificAtlanticWaterFlow.PacificAtlanticWaterFlowRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PacificAtlanticWaterFlowTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 2, 3, 5),
                    intArrayOf(3, 2, 3, 4, 4),
                    intArrayOf(2, 4, 5, 3, 1),
                    intArrayOf(6, 7, 1, 4, 5),
                    intArrayOf(5, 1, 1, 2, 4)
                ),
                listOf(
                    listOf(0, 4),
                    listOf(1, 3),
                    listOf(1, 4),
                    listOf(2, 2),
                    listOf(3, 0),
                    listOf(3, 1),
                    listOf(4, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1)
                ),
                listOf(
                    listOf(0, 0)
                )
            )
        )
    }

    @Nested
    inner class PacificAtlanticWaterFlowRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean`(
            heights: Array<IntArray>,
            expected: List<List<Int>>
        ) {
            PacificAtlanticWaterFlowRev1().test(heights, expected)
        }
    }
}

private fun PacificAtlanticWaterFlow.test(heights: Array<IntArray>, expected: List<List<Int>>) {
    val actual = pacificAtlantic(heights)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
