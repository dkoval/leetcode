package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivideNodesIntoMaximumNumberOfGroups.DivideNodesIntoMaximumNumberOfGroupsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DivideNodesIntoMaximumNumberOfGroupsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 6),
                    intArrayOf(2, 3),
                    intArrayOf(4, 6),
                ),
                4
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 1)
                ),
                -1
            ),
            Arguments.of(
                92,
                arrayOf(
                    intArrayOf(67, 29),
                    intArrayOf(13, 29),
                    intArrayOf(77, 29),
                    intArrayOf(36, 29),
                    intArrayOf(82, 29),
                    intArrayOf(54, 29),
                    intArrayOf(57, 29),
                    intArrayOf(53, 29),
                    intArrayOf(68, 29),
                    intArrayOf(26, 29),
                    intArrayOf(21, 29),
                    intArrayOf(46, 29),
                    intArrayOf(41, 29),
                    intArrayOf(45, 29),
                    intArrayOf(56, 29),
                    intArrayOf(88, 29),
                    intArrayOf(2, 29),
                    intArrayOf(7, 29),
                    intArrayOf(5, 29),
                    intArrayOf(16, 29),
                    intArrayOf(37, 29),
                    intArrayOf(50, 29),
                    intArrayOf(79, 29),
                    intArrayOf(91, 29),
                    intArrayOf(48, 29),
                    intArrayOf(87, 29),
                    intArrayOf(25, 29),
                    intArrayOf(80, 29),
                    intArrayOf(71, 29),
                    intArrayOf(9, 29),
                    intArrayOf(78, 29),
                    intArrayOf(33, 29),
                    intArrayOf(4, 29),
                    intArrayOf(44, 29),
                    intArrayOf(72, 29),
                    intArrayOf(65, 29),
                    intArrayOf(61, 29)
                ),
                57
            )
        )
    }

    @Nested
    inner class DivideNodesIntoMaximumNumberOfGroupsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should divide the nodes into the maximum number of connected groups`(
            n: Int,
            edges: Array<IntArray>,
            expected: Int
        ) {
            DivideNodesIntoMaximumNumberOfGroupsRev1().test(n, edges, expected)
        }
    }
}

private fun DivideNodesIntoMaximumNumberOfGroups.test(n: Int, edges: Array<IntArray>, expected: Int) {
    val actual = magnificentSets(n, edges)
    assertEquals(expected, actual)
}
