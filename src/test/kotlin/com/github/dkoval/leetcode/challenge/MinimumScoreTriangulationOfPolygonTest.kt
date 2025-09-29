package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumScoreTriangulationOfPolygon.MinimumScoreTriangulationOfPolygonRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumScoreTriangulationOfPolygonTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                6
            ),
            Arguments.of(
                intArrayOf(3, 7, 4, 5),
                144
            ),
            Arguments.of(
                intArrayOf(1, 3, 1, 4, 1, 5),
                13
            )
        )
    }

    @Nested
    inner class MinimumScoreTriangulationOfPolygonRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum score of triangulation of polygon`(values: IntArray, expected: Int) {
            MinimumScoreTriangulationOfPolygonRev1().test(values, expected)
        }
    }
}

private fun MinimumScoreTriangulationOfPolygon.test(values: IntArray, expected: Int) {
    val actual = minScoreTriangulation(values)
    assertEquals(expected, actual)
}
