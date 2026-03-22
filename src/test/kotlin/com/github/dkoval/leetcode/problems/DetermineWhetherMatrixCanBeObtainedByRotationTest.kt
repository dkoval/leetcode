package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.DetermineWhetherMatrixCanBeObtainedByRotation.DetermineWhetherMatrixCanBeObtainedByRotationRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class DetermineWhetherMatrixCanBeObtainedByRotationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
                ),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 1)
                ),
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                true
            )
        )
    }

    @Nested
    inner class DetermineWhetherMatrixCanBeObtainedByRotationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if it is possible to make mat equal to target by rotating mat in 90-degree increments`(
            mat: Array<IntArray>,
            target: Array<IntArray>,
            expected: Boolean
        ) {
            DetermineWhetherMatrixCanBeObtainedByRotationRev1().test(mat, target, expected)
        }
    }
}

private fun DetermineWhetherMatrixCanBeObtainedByRotation.test(mat: Array<IntArray>, target: Array<IntArray>, expected: Boolean) {
    val actual = findRotation(mat, target)
    assertEquals(expected, actual)
}
