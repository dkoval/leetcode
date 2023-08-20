package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortItemsByGroupsRespectingDependencies.SortItemsByGroupsRespectingDependenciesRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortItemsByGroupsRespectingDependenciesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                8,
                2,
                intArrayOf(-1, -1, 1, 0, 0, 1, 0, -1),
                listOf(
                    listOf(),
                    listOf(6),
                    listOf(5),
                    listOf(6),
                    listOf(3, 6),
                    listOf(),
                    listOf(),
                    listOf()
                ),
                intArrayOf(6, 3, 4, 5, 2, 0, 7, 1)
            ),
            Arguments.of(
                8,
                2,
                intArrayOf(-1, -1, 1, 0, 0, 1, 0, -1),
                listOf(
                    listOf(),
                    listOf(6),
                    listOf(5),
                    listOf(6),
                    listOf(3),
                    listOf(),
                    listOf(4),
                    listOf()
                ),
                intArrayOf()
            ),
            Arguments.of(
                5,
                5,
                intArrayOf(2, 0, -1, 3, 0),
                listOf(
                    listOf(2, 1, 3),
                    listOf(2, 4),
                    listOf(),
                    listOf(),
                    listOf()
                ),
                intArrayOf(3, 2, 4, 1, 0)
            )
        )
    }

    @Nested
    inner class SortItemsByGroupsRespectingDependenciesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return any solution if there is more than one solution and return an empty list if there is no solution`(
            n: Int,
            m: Int,
            group: IntArray,
            beforeItems: List<List<Int>>,
            expected: IntArray
        ) {
            SortItemsByGroupsRespectingDependenciesRev1().test(n, m, group, beforeItems, expected)
        }
    }
}

private fun SortItemsByGroupsRespectingDependencies.test(
    n: Int,
    m: Int,
    group: IntArray,
    beforeItems: List<List<Int>>,
    expected: IntArray
) {
    val actual = sortItems(n, m, group, beforeItems)
    assertArrayEquals(expected, actual)
}
