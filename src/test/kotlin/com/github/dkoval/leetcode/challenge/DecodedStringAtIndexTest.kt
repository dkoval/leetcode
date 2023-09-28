package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DecodedStringAtIndex.DecodedStringAtIndexRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DecodedStringAtIndexTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("leet2code3", 10, "o"),
            Arguments.of("ha22", 5, "h"),
            Arguments.of("a2345678999999999999999", 1, "a"),
        )
    }

    @Nested
    inner class DecodedStringAtIndexRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the kth letter (1-indexed) in the decoded string`(s: String, k: Int, expected: String) {
            DecodedStringAtIndexRev1().test(s, k, expected)
        }
    }
}

private fun DecodedStringAtIndex.test(s: String, k: Int, expected: String) {
    val actual = decodeAtIndex(s, k)
    assertEquals(expected, actual)
}
