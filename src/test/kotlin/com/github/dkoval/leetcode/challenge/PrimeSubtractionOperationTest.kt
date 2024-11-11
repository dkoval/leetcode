package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PrimeSubtractionOperation.PrimeSubtractionOperationRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PrimeSubtractionOperationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 9, 6, 10),
                true
            ),
            Arguments.of(
                intArrayOf(6, 8, 11, 12),
                true
            ),
            Arguments.of(
                intArrayOf(5, 8, 3),
                false
            )
        )
    }

    @Nested
    inner class PrimeSubtractionOperationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can make nums a strictly increasing array`(nums: IntArray, expected: Boolean) {
            PrimeSubtractionOperationRev1().test(nums, expected)
        }
    }
}

private fun PrimeSubtractionOperation.test(nums: IntArray, expected: Boolean) {
    val actual = primeSubOperation(nums)
    assertEquals(expected, actual)
}
