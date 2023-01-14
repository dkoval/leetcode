package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MedianFinder.MedianFinderRev1
import com.github.dkoval.leetcode.challenge.MedianFinder.MedianFinderRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMedianFromDataStreamTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @Nested
    inner class MedianFinderRev1Test {
        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            MedianFinderRev1().test(commands)
        }
    }

    @Nested
    inner class MedianFinderRev2Test {
        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            MedianFinderRev2().test(commands)
        }
    }

    private fun MedianFinder.test(commands: List<Command>) {
        for (command in commands) {
            when (command) {
                is Command.AddNum -> addNum(command.num)
                is Command.FindMedian -> assertEquals(findMedian(), command.expected, 1E-6)
            }
        }
    }
}