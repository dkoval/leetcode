package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RestoreIPAddresses.RestoreIPAddressesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RestoreIPAddressesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "25525511135",
                listOf("255.255.11.135", "255.255.111.35")
            ),
            Arguments.of(
                "0000",
                listOf("0.0.0.0")
            ),
            Arguments.of(
                "101023",
                listOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")
            )
        )
    }

    @Nested
    inner class RestoreIPAddressesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all possible valid IP addresses`(s: String, expected: List<String>) {
            RestoreIPAddressesRev1().test(s, expected)
        }
    }

    private fun RestoreIPAddresses.test(s: String, expected: List<String>) {
        val actual = restoreIpAddresses(s)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}