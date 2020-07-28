package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TaskSchedulerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                charArrayOf('A', 'A', 'A', 'B', 'B', 'B'),
                2,
                8
                // A -> B -> idle -> A -> B -> idle -> A -> B
                // There is at least 2 units of time between any two same tasks.
            ),
            Arguments.of(
                charArrayOf('A', 'A', 'A', 'B', 'B', 'B'),
                0,
                6
                // On this case any permutation of size 6 would work since n = 0.
                // ["A","A","A","B","B","B"]
                // ["A","B","A","B","A","B"]
                // ["B","B","B","A","A","A"]
                // ...
                // And so on.
            ),
            Arguments.of(
                charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
                2,
                16
                // One possible solution is
                // A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the least number of units of times that the CPU will take to finish all the given tasks`(
        tasks: CharArray,
        n: Int,
        expected: Int
    ) {
        val actual = TaskScheduler.leastInterval(tasks, n)
        assertEquals(expected, actual)
    }
}