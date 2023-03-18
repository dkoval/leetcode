package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BrowserHistory.BrowserHistoryRev1
import com.github.dkoval.leetcode.challenge.BrowserHistoryTest.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BrowserHistoryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "leetcode.com",
                listOf(
                    Command.Visit("google.com"),
                    Command.Visit("facebook.com"),
                    Command.Visit("youtube.com"),
                    Command.Back(1, "facebook.com"),
                    Command.Back(1, "google.com"),
                    Command.Forward(1, "facebook.com"),
                    Command.Visit("linkedin.com"),
                    Command.Forward(2, "linkedin.com"),
                    Command.Back(2, "google.com"),
                    Command.Back(7, "leetcode.com")
                )
            )
        )
    }

    sealed class Command {
        data class Visit(val url: String) : Command()
        data class Back(val steps: Int, val expected: String) : Command()
        data class Forward(val steps: Int, val expected: String) : Command()
    }

    @Nested
    inner class BrowserHistoryRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should verify implementation`(homepage: String, commands: List<Command>) {
            BrowserHistoryRev1(homepage).test(commands)
        }
    }
}

private fun BrowserHistory.test(commands: List<Command>) {
    commands.forEach { command ->
        when (command) {
            is Command.Visit -> visit(command.url)
            is Command.Back -> assertEquals(command.expected, back(command.steps))
            is Command.Forward -> assertEquals(command.expected, forward(command.steps))
        }
    }
}
