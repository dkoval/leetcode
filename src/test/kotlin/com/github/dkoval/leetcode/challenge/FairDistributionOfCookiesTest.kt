package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FairDistributionOfCookies.FairDistributionOfCookiesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FairDistributionOfCookiesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(8, 15, 10, 20, 8),
                2,
                31
            ),
            Arguments.of(
                intArrayOf(6, 1, 3, 2, 2, 4, 1, 2),
                3,
                7
            ),
            Arguments.of(
                intArrayOf(64, 32, 16, 8, 4, 2, 1, 1000),
                8,
                1000
            )
        )
    }

    @Nested
    inner class FairDistributionOfCookiesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum unfairness of all distributions`(cookies: IntArray, k: Int, expected: Int) {
            FairDistributionOfCookiesRev1().test(cookies, k, expected)
        }
    }
}

private fun FairDistributionOfCookies.test(cookies: IntArray, k: Int, expected: Int) {
    val actual = distributeCookies(cookies, k)
    assertEquals(expected, actual)
}
