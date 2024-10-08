package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfSwapsToMakeStringBalanced.MinimumNumberOfSwapsToMakeStringBalancedRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfSwapsToMakeStringBalancedTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "][][",
                1
            ),
            Arguments.of(
                "]]][[[",
                2
            ),
            Arguments.of(
                "[]",
                0
            )
        )
    }

    @Nested
    inner class MinimumNumberOfSwapsToMakeStringBalancedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the minimum number of swaps to make s balanced`(s: String, expected: Int) {
            MinimumNumberOfSwapsToMakeStringBalancedRev1().test(s, expected)
        }
    }
}

private fun MinimumNumberOfSwapsToMakeStringBalanced.test(s: String, expected: Int) {
    val actual = minSwaps(s)
    assertEquals(expected, actual)
}
