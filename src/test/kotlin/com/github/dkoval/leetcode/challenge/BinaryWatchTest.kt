package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BinaryWatch.BinaryWatchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class BinaryWatchTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                listOf("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")
            ),
            Arguments.of(
                9,
                emptyList<String>()
            )
        )
    }

    @Nested
    inner class BinaryWatchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible times on the binary watch`(turnedOn: Int, expected: List<String>) {
            BinaryWatchRev1().test(turnedOn, expected)
        }
    }
}

private fun BinaryWatch.test(turnedOn: Int, expected: List<String>) {
    val actual = readBinaryWatch(turnedOn)
    assertEquals(expected, actual)
}
