package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ZigzagConversion.ZigzagConversionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ZigzagConversionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
            Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
            Arguments.of("AB", 1, "AB")
        )
    }

    @Nested
    inner class ZigzagConversionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should perform zigzag conversion`(s: String, numRows: Int, expected: String) {
            ZigzagConversionRev1().test(s, numRows, expected)
        }
    }
}

private fun ZigzagConversion.test(s: String, numRows: Int, expected: String) {
    val actual = convert(s, numRows)
    assertEquals(expected, actual)
}
