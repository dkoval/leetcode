package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfChangesToMakeBinaryStringBeautiful.MinimumNumberOfChangesToMakeBinaryStringBeautifulRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfChangesToMakeBinaryStringBeautifulTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("1001", 2),
            Arguments.of("10", 1),
            Arguments.of("0000", 0)
        )
    }

    @Nested
    inner class MinimumNumberOfChangesToMakeBinaryStringBeautifulRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of changes required to make the string s beautiful`(
            s: String,
            expected: Int
        ) {
            MinimumNumberOfChangesToMakeBinaryStringBeautifulRev1().test(s, expected)
        }
    }
}

private fun MinimumNumberOfChangesToMakeBinaryStringBeautiful.test(s: String, expected: Int) {
    val actual = minChanges(s)
    assertEquals(expected, actual)
}
