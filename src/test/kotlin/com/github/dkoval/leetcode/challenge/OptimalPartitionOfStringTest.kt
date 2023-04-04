package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.OptimalPartitionOfString.OptimalPartitionOfStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class OptimalPartitionOfStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abacaba", 4),
            Arguments.of("ssssss", 6)
        )
    }

    @Nested
    inner class OptimalPartitionOfStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of substrings in such a partition`(s: String, expected: Int) {
            OptimalPartitionOfStringRev1().test(s, expected)
        }
    }
}

private fun OptimalPartitionOfString.test(s: String, expected: Int) {
    val actual = partitionString(s)
    assertEquals(expected, actual)
}
