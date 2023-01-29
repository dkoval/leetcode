package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LFUCache.LFUCacheRev1
import com.github.dkoval.leetcode.challenge.LFUCacheTest.Command
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LFUCacheTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                listOf(
                    Command.Put(1, 1),
                    Command.Put(2, 2),
                    Command.Get(1, 1),
                    Command.Put(3, 3),
                    Command.Get(2, -1),
                    Command.Get(3, 3),
                    Command.Put(4, 4),
                    Command.Get(1, -1),
                    Command.Get(3, 3),
                    Command.Get(4, 4)
                )
            ),
            Arguments.of(
                0,
                listOf(
                    Command.Put(0, 0),
                    Command.Get(0, -1)
                )
            )
        )
    }

    sealed class Command {
        data class Get(val key: Int, val expected: Int) : Command()
        data class Put(val key: Int, val value: Int) : Command()
    }

    @Nested
    inner class LFUCacheRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should verify implementation`(capacity: Int, commands: List<Command>) {
            LFUCacheRev1(capacity).test(commands)
        }
    }
}

private fun LFUCache.test(commands: List<Command>) {
    commands.forEach { command ->
        when (command) {
            is Command.Get -> assertEquals(command.expected, get(command.key))
            is Command.Put -> put(command.key, command.value)
        }
    }
}
