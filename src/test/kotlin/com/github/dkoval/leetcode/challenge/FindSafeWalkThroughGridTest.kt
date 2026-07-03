package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindSafeWalkThroughGrid.FindSafeWalkThroughGridRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindSafeWalkThroughGridTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        listOf(0, 1, 0, 0, 0),
                        listOf(0, 1, 0, 1, 0),
                        listOf(0, 0, 0, 1, 0)
                    ),
                    1,
                    true
                ),
                Arguments.of(
                    listOf(
                        listOf(0, 1, 1, 0, 0, 0),
                        listOf(1, 0, 1, 0, 0, 0),
                        listOf(0, 1, 1, 1, 0, 1),
                        listOf(0, 0, 1, 0, 1, 0)
                    ),
                    3,
                    false
                ),
                Arguments.of(
                    listOf(
                        listOf(1, 1, 1),
                        listOf(1, 0, 1),
                        listOf(1, 1, 1)
                    ),
                    5,
                    true
                )
            )
        }
    }

    @Nested
    inner class FindSafeWalkThroughGridRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if there is a safe walk through the grid`(
            grid: List<List<Int>>,
            health: Int,
            expected: Boolean
        ) {
            FindSafeWalkThroughGridRev1().test(grid, health, expected)
        }
    }
}

private fun FindSafeWalkThroughGrid.test(grid: List<List<Int>>, health: Int, expected: Boolean) {
    val actual = findSafeWalk(grid, health)
    assertEquals(expected, actual)
}
