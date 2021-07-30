package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MapSumPairs.MapSum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MapSumPairsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    Command.Insert("apple", 3),
                    Command.Sum("ap", 3),
                    Command.Insert("app", 2),
                    Command.Sum("ap", 5)
                )
            ),
            Arguments.of(
                listOf(
                    Command.Insert("a", 3),
                    Command.Sum("ap", 0),
                    Command.Insert("b", 2),
                    Command.Sum("a", 3)
                )
            )
        )
    }

    sealed class Command {
        class Insert(val key: String, val `val`: Int) : Command()
        class Sum(val prefix: String, val expected: Int) : Command()
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `verify implementation`(commands: List<Command>) {
        val solution = MapSum()
        for (command in commands) {
            when (command) {
                is Command.Insert -> solution.insert(command.key, command.`val`)
                is Command.Sum -> assertEquals(command.expected, solution.sum(command.prefix))
            }
        }
    }
}