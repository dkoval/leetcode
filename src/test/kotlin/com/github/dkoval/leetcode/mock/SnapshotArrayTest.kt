package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.SnapshotArray.SnapshotArrayMemoryInefficient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SnapshotArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                listOf(
                    Command.Set(0, 5),
                    Command.Snap(0),
                    Command.Set(0, 6),
                    Command.Get(0, 0, 5)
                )
            ),
            Arguments.of(
                2,
                listOf(
                    Command.Snap(0),
                    Command.Get(1, 0, 0),
                    Command.Get(0, 0, 0),
                    Command.Set(1, 8),
                    Command.Get(1, 0, 0),
                    Command.Set(0, 20),
                    Command.Get(0, 0, 0),
                    Command.Set(0, 7)
                )
            ),
            Arguments.of(
                1,
                listOf(
                    Command.Set(0, 15),
                    Command.Snap(0),
                    Command.Snap(1),
                    Command.Snap(2),
                    Command.Get(0, 2, 15),
                    Command.Snap(3),
                    Command.Snap(4),
                    Command.Get(0, 0, 15)
                )
            )
        )
    }

    sealed class Command {
        class Set(val index: Int, val `val`: Int) : Command()
        class Snap(val expectedId: Int) : Command()
        class Get(val index: Int, val snapId: Int, val expectedVal: Int) : Command()
    }

    @Nested
    inner class SnapshotArrayMemoryInefficientTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate SnapshotArray implementation`(length: Int, commands: List<Command>) {
            SnapshotArrayMemoryInefficient(length).test(commands)
        }
    }

    private fun SnapshotArray.test(commands: List<Command>) {
        for (command in commands) {
            when (command) {
                is Command.Set -> set(command.index, command.`val`)
                is Command.Snap -> assertEquals(
                    command.expectedId,
                    snap(),
                    "Wrong value returned for snapId"
                )
                is Command.Get -> assertEquals(
                    command.expectedVal,
                    get(command.index, command.snapId),
                    "Wrong value returned for index: ${command.index}, snapId: ${command.snapId}"
                )
            }
        }
    }
}