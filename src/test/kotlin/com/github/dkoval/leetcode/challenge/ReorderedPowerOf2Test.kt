package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReorderedPowerOf2.ReorderedPowerOf2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReorderedPowerOf2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, true),
            Arguments.of(10, false),
            Arguments.of(16, true),
            Arguments.of(24, false),
            Arguments.of(46, true)
        )
    }

    @Nested
    inner class ReorderedPowerOf2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if N is reordered power of 2`(n: Int, expected: Boolean) {
            ReorderedPowerOf2Rev1().test(n, expected)
        }
    }
}

private fun ReorderedPowerOf2.test(n: Int, expected: Boolean) {
    val actual = reorderedPowerOf2(n)
    assertEquals(expected, actual)
}
