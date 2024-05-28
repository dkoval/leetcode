package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GetEqualSubstringsWithinBudget.GetEqualSubstringsWithinBudgetRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GetEqualSubstringsWithinBudgetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcd", "bcdf", 3, 3),
            Arguments.of("abcd", "cdef", 3, 1),
            Arguments.of("abcd", "acde", 0, 1)
        )
    }

    @Nested
    inner class GetEqualSubstringsWithinBudgetRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the max length of a substr of s that can be changed to the corresponding substr of t with a cost lte to maxCost`(
            s: String,
            t: String,
            maxCost: Int,
            expected: Int
        ) {
            GetEqualSubstringsWithinBudgetRev1().test(s, t, maxCost, expected)
        }
    }
}

private fun GetEqualSubstringsWithinBudget.test(s: String, t: String, maxCost: Int, expected: Int) {
    val actual = equalSubstring(s, t, maxCost)
    assertEquals(expected, actual)
}
