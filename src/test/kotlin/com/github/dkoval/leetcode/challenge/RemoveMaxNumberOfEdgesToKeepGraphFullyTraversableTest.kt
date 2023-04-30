package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable.RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(intArrayOf(3, 1, 2), intArrayOf(3, 2, 3), intArrayOf(1, 1, 3), intArrayOf(1, 2, 4), intArrayOf(1, 1, 2), intArrayOf(2, 3, 4)),
                2
            ),
            Arguments.of(
                4,
                arrayOf(intArrayOf(3, 1, 2), intArrayOf(3, 2, 3), intArrayOf(1, 1, 4), intArrayOf(2, 1, 4)),
                0
            ),
            Arguments.of(
                4,
                arrayOf(intArrayOf(3, 2, 3), intArrayOf(1, 1, 2), intArrayOf(2, 3, 4)),
                -1
            )
        )
    }

    @Nested
    inner class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of edges you can remove`(n: Int, edges: Array<IntArray>, expected: Int) {
            RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableRev1().test(n, edges, expected)
        }
    }
}

private fun RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable.test(n: Int, edges: Array<IntArray>, expected: Int) {
    val actual = maxNumEdgesToRemove(n, edges)
    assertEquals(expected, actual)
}
