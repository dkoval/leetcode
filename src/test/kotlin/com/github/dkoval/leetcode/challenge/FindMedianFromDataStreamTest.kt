package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMedianFromDataStream.MedianFinder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindMedianFromDataStreamTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    Command.AddNum(1),
                    Command.AddNum(2),
                    Command.FindMedian(1.5),
                    Command.AddNum(3),
                    Command.FindMedian(2.0)
                )
            )
        )
    }

    sealed class Command {
        data class AddNum(val num: Int) : Command()
        data class FindMedian(val expected: Double) : Command()
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(commands: List<Command>) {
        val solution = MedianFinder()
        for (command in commands) {
            when (command) {
                is Command.AddNum -> solution.addNum(command.num)
                is Command.FindMedian -> assertEquals(solution.findMedian(), command.expected, 1E-6)
            }
        }
    }
}