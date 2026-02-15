package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AddBinary.AddBinaryRev2
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

internal class AddBinaryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments("11", "1", "100"),
            arguments("1010", "1011", "10101")
        )
    }

    @Nested
    inner class AddBinaryRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return sum of two binary strings`(a: String, b: String, expected: String) {
            AddBinaryRev1.test(a, b, expected)
        }
    }

    @Nested
    inner class AddBinaryRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return sum of two binary strings`(a: String, b: String, expected: String) {
            AddBinaryRev2().test(a, b, expected)
        }
    }
}

private fun AddBinary.test(a: String, b: String, expected: String) {
    val actual = addBinary(a, b)
    assertEquals(expected, actual)
}
