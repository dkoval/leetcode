package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestNumberInInfiniteSet.SmallestNumberInInfiniteSetRev1
import com.github.dkoval.leetcode.challenge.SmallestNumberInInfiniteSetTest.Command
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SmallestNumberInInfiniteSetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Command.AddBack(2),
                    Command.PopSmallest(1),
                    Command.PopSmallest(2),
                    Command.PopSmallest(3),
                    Command.AddBack(1),
                    Command.PopSmallest(1),
                    Command.PopSmallest(4),
                    Command.PopSmallest(5)
                )
            )
        )
    }

    sealed class Command {
        data class PopSmallest(val expected: Int): Command()
        data class AddBack(val num: Int): Command()
    }

    @Nested
    inner class SmallestNumberInInfiniteSetRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            SmallestNumberInInfiniteSetRev1().test(commands)
        }
    }
}

private fun SmallestNumberInInfiniteSet.test(commands: List<Command>) {
    for (command in commands) {
        when (command) {
            is Command.PopSmallest -> assertEquals(command.expected, popSmallest())
            is Command.AddBack -> addBack(command.num)
        }
    }
}
