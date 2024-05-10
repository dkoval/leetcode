package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthSmallestPrimeFraction.KthSmallestPrimeFractionRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KthSmallestPrimeFractionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 5),
                3,
                intArrayOf(2, 5)
            ),
            Arguments.of(
                intArrayOf(1, 7),
                1,
                intArrayOf(1, 7)
            )
        )
    }

    @Nested
    inner class KthSmallestPrimeFractionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the k-th smallest fraction considered`(arr: IntArray, k: Int, expected: IntArray) {
            KthSmallestPrimeFractionRev1().test(arr, k, expected)
        }
    }
}

private fun KthSmallestPrimeFraction.test(arr: IntArray, k: Int, expected: IntArray) {
    val actual = kthSmallestPrimeFraction(arr, k)
    assertArrayEquals(expected, actual)
}
