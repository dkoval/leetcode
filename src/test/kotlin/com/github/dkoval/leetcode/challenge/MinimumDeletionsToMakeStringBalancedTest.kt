package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumDeletionsToMakeStringBalanced.MinimumDeletionsToMakeStringBalancedRev1
import com.github.dkoval.leetcode.challenge.MinimumDeletionsToMakeStringBalanced.MinimumDeletionsToMakeStringBalancedRev2
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

internal class MinimumDeletionsToMakeStringBalancedTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> =
            Stream.of(
                arguments(
                    "aababbab",
                    2
                ),
                arguments(
                    "bbaaaaabb",
                    2
                )
            )
    }

    @Nested
    inner class MinimumDeletionsToMakeStringBalancedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of deletions needed to make s balanced`(
            s: String,
            expected: Int
        ) {
            MinimumDeletionsToMakeStringBalancedRev1().test(s, expected)
        }
    }

    @Nested
    inner class MinimumDeletionsToMakeStringBalancedRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of deletions needed to make s balanced`(
            s: String,
            expected: Int
        ) {
            MinimumDeletionsToMakeStringBalancedRev2().test(s, expected)
        }
    }
}

private fun MinimumDeletionsToMakeStringBalanced.test(s: String, expected: Int) {
    val actual = minimumDeletions(s)
    assertEquals(expected, actual)
}
