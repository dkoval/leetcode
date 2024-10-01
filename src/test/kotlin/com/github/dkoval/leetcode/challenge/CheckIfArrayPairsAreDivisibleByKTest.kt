package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfArrayPairsAreDivisibleByK.CheckIfArrayPairsAreDivisibleByKRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfArrayPairsAreDivisibleByKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9),
                5,
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6),
                7,
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6),
                10,
                false
            ),
            Arguments.of(
                intArrayOf(-1, 1, -2, 2, -3, 3, -4, 4),
                3,
                true
            )
        )
    }

    @Nested
    inner class CheckIfArrayPairsAreDivisibleByKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if we can divide the array into pairs such that the sum of each pair is divisible by k`(
            arr: IntArray,
            k: Int,
            expected: Boolean
        ) {
            CheckIfArrayPairsAreDivisibleByKRev1().test(arr, k, expected)
        }
    }
}

private fun CheckIfArrayPairsAreDivisibleByK.test(arr: IntArray, k: Int, expected: Boolean) {
    val actual = canArrange(arr, k)
    assertEquals(expected, actual)
}
