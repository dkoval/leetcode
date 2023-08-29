package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumPenaltyForShop.MinimumPenaltyForShopRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumPenaltyForShopTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("YYNY", 2),
            Arguments.of("NNNNN", 0),
            Arguments.of("YYYY", 4)
        )
    }

    @Nested
    inner class MinimumPenaltyForShopRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the earliest hour at which the shop must be closed to incur a minimum penalty`(
            customers: String,
            expected: Int
        ) {
            MinimumPenaltyForShopRev1().test(customers, expected)
        }
    }
}

private fun MinimumPenaltyForShop.test(customers: String, expected: Int) {
    val actual = bestClosingTime(customers)
    assertEquals(expected, actual)
}
