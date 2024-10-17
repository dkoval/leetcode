package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumSwap.MaximumSwapRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumSwapTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2736, 7236),
            Arguments.of(9973, 9973),
            Arguments.of(1, 1)
        )
    }

    @Nested
    inner class MaximumSwapRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum valued number you can get`(num: Int, expected: Int) {
            MaximumSwapRev1().test(num, expected)
        }
    }
}

private fun MaximumSwap.test(num: Int, expected: Int) {
    val actual = maximumSwap(num)
    assertEquals(expected, actual)
}
