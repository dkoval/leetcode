package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountOperationsToObtainZero.CountOperationsToObtainZeroRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountOperationsToObtainZeroTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 3, 3),
            Arguments.of(10, 10, 1)
        )
    }


    @Nested
    inner class CountOperationsToObtainZeroRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of operations required to make either num1 or num2 equal to 0`(
            num1: Int,
            num2: Int,
            expected: Int
        ) {
            CountOperationsToObtainZeroRev1().test(num1, num2, expected)
        }
    }
}

private fun CountOperationsToObtainZero.test(num1: Int, num2: Int, expected: Int) {
    val actual = countOperations(num1, num2)
    assertEquals(expected, actual)
}
