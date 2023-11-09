package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountNumberOfHomogenousSubstrings.CountNumberOfHomogenousSubstringsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountNumberOfHomogenousSubstringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abbcccaa",
                13
            ),
            Arguments.of(
                "xy",
                2
            ),
            Arguments.of(
                "zzzzz",
                15
            )
        )
    }

    @Nested
    inner class CountNumberOfHomogenousSubstringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of homogenous substrings of s`(s: String, expected: Int) {
            CountNumberOfHomogenousSubstringsRev1().test(s, expected)
        }
    }
}

private fun CountNumberOfHomogenousSubstrings.test(s: String, expected: Int) {
    val actual = countHomogenous(s)
    assertEquals(expected, actual)
}
