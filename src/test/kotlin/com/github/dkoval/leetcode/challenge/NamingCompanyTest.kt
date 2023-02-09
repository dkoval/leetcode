package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NamingCompany.NamingCompanyRev1
import com.github.dkoval.leetcode.challenge.NamingCompany.NamingCompanyTLE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NamingCompanyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("coffee", "donuts", "time", "toffee"),
                6
            ),
            Arguments.of(
                arrayOf("lack", "back"),
                0
            )
        )
    }

    @Nested
    inner class NamingCompanyTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct valid names for the company`(ideas: Array<String>, expected: Long) {
            NamingCompanyTLE().test(ideas, expected)
        }
    }

    @Nested
    inner class NamingCompanyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of distinct valid names for the company`(ideas: Array<String>, expected: Long) {
            NamingCompanyRev1().test(ideas, expected)
        }
    }
}

private fun NamingCompany.test(ideas: Array<String>, expected: Long) {
    val actual = distinctNames(ideas)
    assertEquals(expected, actual)
}
