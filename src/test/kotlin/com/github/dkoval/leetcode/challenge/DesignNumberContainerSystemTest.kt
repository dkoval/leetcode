package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DesignNumberContainerSystem.NumberContainersRev1
import com.github.dkoval.leetcode.challenge.DesignNumberContainerSystemTest.Command.Change
import com.github.dkoval.leetcode.challenge.DesignNumberContainerSystemTest.Command.Find
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DesignNumberContainerSystemTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Find(10, -1),
                    Change(2, 10),
                    Change(1, 10),
                    Change(3, 10),
                    Change(5, 10),
                    Find(10, 1),
                    Change(1, 20),
                    Find(10, 2)
                )
            ),
            Arguments.of(
                listOf(
                    Change(1, 10),
                    Find(10, 1),
                    Change(1, 20),
                    Find(10, -1),
                    Find(20, 1),
                    Find(30, -1)
                )
            )
        )
    }

    sealed interface Command {
        data class Change(val index: Int, val number: Int) : Command
        data class Find(val number: Int, val expected: Int) : Command
    }

    @Nested
    inner class NumberContainersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate the correctness of the design`(commands: List<Command>) {
            val system = NumberContainersRev1()
            for (command in commands) {
                when (command) {
                    is Change -> {
                        system.change(command.index, command.number)
                    }

                    is Find -> {
                        val actual = system.find(command.number)
                        assertEquals(command.expected, actual)
                    }
                }
            }
        }
    }
}