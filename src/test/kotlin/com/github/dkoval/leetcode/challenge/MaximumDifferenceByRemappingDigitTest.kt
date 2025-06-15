package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumDifferenceByRemappingDigit.MaximumDifferenceByRemappingDigitRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDifferenceByRemappingDigitTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(11891, 99009),
            Arguments.of(90, 99)
        )
    }

    @Nested
    inner class MaximumDifferenceByRemappingDigitRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum difference by remapping digits`(
            num: Int,
            expected: Int
        ) {
            MaximumDifferenceByRemappingDigitRev1().test(num, expected)
        }
    }
}

private fun MaximumDifferenceByRemappingDigit.test(num: Int, expected: Int) {
    val actual = minMaxDifference(num)
    assertEquals(expected, actual)
}
