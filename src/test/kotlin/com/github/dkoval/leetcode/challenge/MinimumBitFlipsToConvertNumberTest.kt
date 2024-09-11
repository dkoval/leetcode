package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumBitFlipsToConvertNumber.MinimumBitFlipsToConvertNumberRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumBitFlipsToConvertNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(10, 7, 3),
            Arguments.of(3, 4, 3)
        )
    }

    @Nested
    inner class MinimumBitFlipsToConvertNumberRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of bit flips to convert start to goal`(
            start: Int,
            goal: Int,
            expected: Int
        ) {
            MinimumBitFlipsToConvertNumberRev1().test(start, goal, expected)
        }
    }
}

private fun MinimumBitFlipsToConvertNumber.test(start: Int, goal: Int, expected: Int) {
    val actual = minBitFlips(start, goal)
    assertEquals(expected, actual)
}
