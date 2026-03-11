package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ComplementOfBase10Integer.ComplementOfBase10IntegerRev1
import com.github.dkoval.leetcode.challenge.ComplementOfBase10Integer.ComplementOfBase10IntegerRev2
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

internal class ComplementOfBase10IntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(5, 2),
            arguments(7, 0),
            arguments(10, 5),
            arguments(0, 1)
        )
    }

    @Nested
    inner class ComplementOfBase10IntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the complement of base 10 integer n`(n: Int, expected: Int) {
            ComplementOfBase10IntegerRev1().test(n, expected)
        }
    }

    @Nested
    inner class ComplementOfBase10IntegerRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the complement of base 10 integer n`(n: Int, expected: Int) {
            ComplementOfBase10IntegerRev2().test(n, expected)
        }
    }
}

private fun ComplementOfBase10Integer.test(n: Int, expected: Int) {
    val actual = bitwiseComplement(n)
    assertEquals(expected, actual)
}
