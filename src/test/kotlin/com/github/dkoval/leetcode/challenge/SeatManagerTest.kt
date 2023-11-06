package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SeatManager.SeatManagerRev1
import com.github.dkoval.leetcode.challenge.SeatManager.SeatManagerRev2
import com.github.dkoval.leetcode.challenge.SeatManagerTest.Command
import com.github.dkoval.leetcode.challenge.SeatManagerTest.Command.Reserve
import com.github.dkoval.leetcode.challenge.SeatManagerTest.Command.Unreserve
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SeatManagerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                listOf(
                    Reserve(1),
                    Reserve(2),
                    Unreserve(2),
                    Reserve(2),
                    Reserve(3),
                    Reserve(4),
                    Reserve(5),
                    Unreserve(5)
                )
            )
        )
    }

    sealed interface Command {
        data class Reserve(val expected: Int) : Command
        data class Unreserve(val seatNumber: Int): Command
    }

    @Nested
    inner class SeatManagerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(n: Int, commands: List<Command>) {
            SeatManagerRev1(n).test(commands)
        }
    }

    @Nested
    inner class SeatManagerRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(n: Int, commands: List<Command>) {
            SeatManagerRev2(n).test(commands)
        }
    }
}

private fun SeatManager.test(commands: List<Command>) {
    for (command in commands) {
        when (command) {
            is Reserve -> assertEquals(command.expected, reserve())
            is Unreserve -> unreserve(command.seatNumber)
        }
    }
}
