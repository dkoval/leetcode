package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DesignGraphWithShortestPathCalculator.Graph
import com.github.dkoval.leetcode.challenge.DesignGraphWithShortestPathCalculator.GraphRev1
import com.github.dkoval.leetcode.challenge.DesignGraphWithShortestPathCalculatorTest.Command.AddEdge
import com.github.dkoval.leetcode.challenge.DesignGraphWithShortestPathCalculatorTest.Command.ShortestPath
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DesignGraphWithShortestPathCalculatorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 2, 5),
                    intArrayOf(0, 1, 2),
                    intArrayOf(1, 2, 1),
                    intArrayOf(3, 0, 3)
                ),
                listOf(
                    ShortestPath(3, 2, 6),
                    ShortestPath(0, 3, -1),
                    AddEdge(1, 3, 4),
                    ShortestPath(0, 3, 6)
                )
            )
        )
    }

    sealed interface Command {
        class AddEdge(src: Int, dst: Int, cost: Int) : Command {
            val edge: IntArray = intArrayOf(src, dst, cost)
        }
        class ShortestPath(val src: Int, val dst: Int, val expected: Int) : Command
    }

    @Nested
    inner class DesignGraphWithShortestPathCalculatorRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(n: Int, edges: Array<IntArray>, commands: List<Command>) {
            GraphRev1(n, edges).test(commands)
        }
    }
}

private fun Graph.test(commands: List<DesignGraphWithShortestPathCalculatorTest.Command>) {
    assertAll(commands.map {
        when (it) {
            is AddEdge -> { -> addEdge(it.edge) }
            is ShortestPath -> { -> assertEquals(it.expected, shortestPath(it.src, it.dst)) }
        }
    })
}
