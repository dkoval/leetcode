package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BinaryGap.BinaryGapRev1
import com.github.dkoval.leetcode.challenge.BinaryGap.BinaryGapRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class BinaryGapTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(22, 2),
            arguments(8, 0),
            arguments(5, 2)
        )
    }

    @Nested
    inner class BinaryGapRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest distance between two consecutive 1's in the binary representation of n`(
            n: Int,
            expected: Int
        ) {
            BinaryGapRev1().test(n, expected)
        }
    }

    @Nested
    inner class BinaryGapRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest distance between two consecutive 1's in the binary representation of n`(
            n: Int,
            expected: Int
        ) {
            BinaryGapRev2().test(n, expected)
        }
    }
}

private fun BinaryGap.test(n: Int, expected: Int) {
    val actual = binaryGap(n)
    assertEquals(expected, actual)
}
