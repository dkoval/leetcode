package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveMethodsFromProject.RemoveMethodsFromProjectRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class RemoveMethodsFromProjectTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                1,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(0, 1),
                    intArrayOf(3, 2)
                ),
                listOf(0, 1, 2, 3)
            ),
            Arguments.of(
                5,
                0,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(0, 2),
                    intArrayOf(0, 1),
                    intArrayOf(3, 4)
                ),
                listOf(3, 4)
            ),
            Arguments.of(
                3,
                2,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(0, 1),
                    intArrayOf(2, 0)
                ),
                emptyList<Int>()
            )
        )
    }

    @Nested
    inner class RemoveMethodsFromProjectRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array containing all the remaining methods after removing all the suspicious methods`(
            n: Int,
            k: Int,
            invocations: Array<IntArray>,
            expected: List<Int>
        ) {
            RemoveMethodsFromProjectRev1().test(n, k, invocations, expected)
        }
    }
}

private fun RemoveMethodsFromProject.test(n: Int, k: Int, invocations: Array<IntArray>, expected: List<Int>) {
    val actual = remainingMethods(n, k, invocations)
    assertEquals(expected, actual)
}
