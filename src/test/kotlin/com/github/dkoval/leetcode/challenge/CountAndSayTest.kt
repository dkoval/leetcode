package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountAndSay.CountAndSayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountAndSayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(4, "1211")
        )
    }

    @Nested
    inner class CountAndSayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the n-th term of the count-and-say sequence`(n: Int, expected: String) {
            CountAndSayRev1().test(n, expected)
        }
    }
}

private fun CountAndSay.test(n: Int, expected: String) {
    val actual = countAndSay(n)
    assertEquals(expected, actual)
}
