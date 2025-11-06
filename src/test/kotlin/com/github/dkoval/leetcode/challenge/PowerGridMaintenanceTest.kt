package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PowerGridMaintenance.PowerGridMaintenanceRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PowerGridMaintenanceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(4, 5)
                ),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(1, 2)
                ),
                intArrayOf(3, 2, 3)
            ),
            Arguments.of(
                3,
                arrayOf<IntArray>(),
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(2, 1),
                    intArrayOf(1, 1)
                ),
                intArrayOf(1, -1)
            )
        )
    }

    @Nested
    inner class PowerGridMaintenanceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of integers representing the results of each query`(
            c: Int, connections:
            Array<IntArray>,
            queries: Array<IntArray>,
            expected: IntArray
        ) {
            PowerGridMaintenanceRev1().test(c, connections, queries, expected)
        }
    }
}

private fun PowerGridMaintenance.test(
    c: Int,
    connections: Array<IntArray>,
    queries: Array<IntArray>,
    expected: IntArray
) {
    val actual = processQueries(c, connections, queries)
    assertArrayEquals(expected, actual)
}
