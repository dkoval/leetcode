package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumStringLengthAfterRemovingSubstrings.MinimumStringLengthAfterRemovingSubstringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumStringLengthAfterRemovingSubstringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("ABFCACDB", 2),
            Arguments.of("ACBBD", 5)
        )
    }

    @Nested
    inner class MinimumStringLengthAfterRemovingSubstringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible length of the resulting string that you can obtain`(
            s: String,
            expected: Int
        ) {
            MinimumStringLengthAfterRemovingSubstringsRev1().test(s, expected)
        }
    }
}

private fun MinimumStringLengthAfterRemovingSubstrings.test(s: String, expected: Int) {
    val actual = minLength(s)
    assertEquals(expected, actual)
}
