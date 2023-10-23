package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PowerOfFour.PowerOfFourRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PowerOfFourTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(16, true),
            Arguments.of(32, false)
        )
    }

    @Nested
    inner class PowerOfFourRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check whether a number is a power of 4`(n: Int, expected: Boolean) {
            PowerOfFourRev1().test(n, expected)
        }
    }

    @Nested
    inner class PowerOfFourRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check whether a number is a power of 4`(n: Int, expected: Boolean) {
            PowerOfFourRev2.test(n, expected)
        }
    }
}

private fun PowerOfFour.test(n: Int, expected: Boolean) {
    val actual = isPowerOfFour(n)
    assertEquals(expected, actual)
}
