package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DataStreamDisjointIntervals.*
import com.github.dkoval.leetcode.challenge.DataStreamDisjointIntervalsTest.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DataStreamDisjointIntervalsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Command.Add(1),
                    Command.GetIntervals(listOf(intArrayOf(1, 1))),
                    Command.Add(3),
                    Command.GetIntervals(listOf(intArrayOf(1, 1), intArrayOf(3, 3))),
                    Command.Add(7),
                    Command.GetIntervals(listOf(intArrayOf(1, 1), intArrayOf(3, 3), intArrayOf(7, 7))),
                    Command.Add(2),
                    Command.GetIntervals(listOf(intArrayOf(1, 3), intArrayOf(7, 7))),
                    Command.Add(6),
                    Command.GetIntervals(listOf(intArrayOf(1, 3), intArrayOf(6, 7)))
                )
            )
        )
    }

    sealed class Command {
        data class Add(val value: Int) : Command()
        data class GetIntervals(val expected: List<IntArray>) : Command()
    }

    @Nested
    inner class DataStreamDisjointIntervalsNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should verify implementation`(commands: List<Command>) {
            DataStreamDisjointIntervalsNaive().test(commands)
        }
    }
}

private fun DataStreamDisjointIntervals.SummaryRanges.test(commands: List<Command>) {
    commands.forEach { command ->
        when (command) {
            is Command.Add -> addNum(command.value)
            is Command.GetIntervals -> assertThat(intervals.asIterable()).containsExactlyElementsOf(command.expected)
        }
    }
}
