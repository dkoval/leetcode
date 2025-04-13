package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountGoodNumbers.CountGoodNumbersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountGoodNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1L, 5),
            Arguments.of(4, 400),
            Arguments.of(50L, 564908303),
            Arguments.of(806166225460393L, 643535977)
        )
    }

    @Nested
    inner class CountGoodNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the total number of good digit strings of length n`(n: Long, expected: Int) {
            CountGoodNumbersRev1().test(n, expected)
        }
    }
}

private fun CountGoodNumbers.test(n: Long, expected: Int) {
    val actual = countGoodNumbers(n)
    assertEquals(expected, actual)
}
