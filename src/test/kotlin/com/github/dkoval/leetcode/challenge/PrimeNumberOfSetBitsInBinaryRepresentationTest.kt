package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PrimeNumberOfSetBitsInBinaryRepresentation.PrimeNumberOfSetBitsInBinaryRepresentationRev1
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

internal class PrimeNumberOfSetBitsInBinaryRepresentationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(6, 10, 4),
            arguments(10, 15, 5)
        )
    }

    @Nested
    inner class PrimeNumberOfSetBitsInBinaryRepresentationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the count of numbers in the inclusive range having a prime number of set bits in their binary representation`(
            left: Int,
            right: Int,
            expected: Int
        ) {
            PrimeNumberOfSetBitsInBinaryRepresentationRev1().test(left, right, expected)
        }
    }
}

private fun PrimeNumberOfSetBitsInBinaryRepresentation.test(left: Int, right: Int, expected: Int) {
    val actual = countPrimeSetBits(left, right)
    assertEquals(expected, actual)
}
