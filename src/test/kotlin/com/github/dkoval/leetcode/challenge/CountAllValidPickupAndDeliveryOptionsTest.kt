package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountAllValidPickupAndDeliveryOptions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountAllValidPickupAndDeliveryOptionsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 6),
            Arguments.of(3, 90),
            Arguments.of(4, 2520),
            Arguments.of(5, 113400),
            Arguments.of(6, 7484400),
            Arguments.of(7, 681080400),
            Arguments.of(8, 729647433)
        )
    }

    @Nested
    inner class CountAllValidPickupAndDeliveryOptionsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count all valid pickup-delivery possible sequences such that delivery(i) is always after of pickup(i)`(
            n: Int,
            expected: Int
        ) {
            CountAllValidPickupAndDeliveryOptionsDPTopDown().test(n, expected)
        }
    }

    @Nested
    inner class CountAllValidPickupAndDeliveryOptionsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count all valid pickup-delivery possible sequences such that delivery(i) is always after of pickup(i)`(
            n: Int,
            expected: Int
        ) {
            CountAllValidPickupAndDeliveryOptionsRev1().test(n, expected)
        }
    }

    @Nested
    inner class CountAllValidPickupAndDeliveryOptionsDiscreteMathTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count all valid pickup-delivery possible sequences such that delivery(i) is always after of pickup(i)`(
            n: Int,
            expected: Int
        ) {
            CountAllValidPickupAndDeliveryOptionsDiscreteMath().test(n, expected)
        }
    }
}

private fun CountAllValidPickupAndDeliveryOptions.test(n: Int, expected: Int) {
    val actual = countOrders(n)
    assertEquals(expected, actual)
}
