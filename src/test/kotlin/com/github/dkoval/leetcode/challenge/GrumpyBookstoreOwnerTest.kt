package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GrumpyBookstoreOwner.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GrumpyBookstoreOwnerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 0, 1, 2, 1, 1, 7, 5),
                intArrayOf(0, 1, 0, 1, 0, 1, 0, 1),
                3,
                16
            ),
            Arguments.of(
                intArrayOf(1),
                intArrayOf(0),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(4, 10, 10),
                intArrayOf(1, 1, 0),
                2,
                24
            ),
            Arguments.of(
                intArrayOf(2, 6, 6, 9),
                intArrayOf(0, 0, 1, 1),
                1,
                17
            )
        )
    }

    @Nested
    inner class GrumpyBookstoreOwnerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of customers that can be satisfied throughout the day`(
            customers: IntArray,
            grumpy: IntArray,
            minutes: Int,
            expected: Int
        ) {
            GrumpyBookstoreOwnerRev1().test(customers, grumpy, minutes, expected)
        }
    }

    @Nested
    inner class GrumpyBookstoreOwnerRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of customers that can be satisfied throughout the day`(
            customers: IntArray,
            grumpy: IntArray,
            minutes: Int,
            expected: Int
        ) {
            GrumpyBookstoreOwnerRev2().test(customers, grumpy, minutes, expected)
        }
    }

    @Nested
    inner class GrumpyBookstoreOwnerRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of customers that can be satisfied throughout the day`(
            customers: IntArray,
            grumpy: IntArray,
            minutes: Int,
            expected: Int
        ) {
            GrumpyBookstoreOwnerRev3().test(customers, grumpy, minutes, expected)
        }
    }
}

private fun GrumpyBookstoreOwner.test(customers: IntArray, grumpy: IntArray, minutes: Int, expected: Int) {
    val actual = maxSatisfied(customers, grumpy, minutes)
    assertEquals(expected, actual)
}
