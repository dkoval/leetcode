package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfIntegersToChooseFromRange1.MaximumNumberOfIntegersToChooseFromRange1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfIntegersToChooseFromRange1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 6, 5),
                5,
                6,
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                8,
                1,
                0
            ),
            Arguments.of(
                intArrayOf(11),
                7,
                50,
                7
            )
        )
    }

    @Nested
    inner class MaximumNumberOfIntegersToChooseFromRange1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of integers you can choose following the rules`(
            banned: IntArray,
            n: Int,
            maxSum: Int,
            expected: Int
        ) {
            MaximumNumberOfIntegersToChooseFromRange1Rev1().test(banned, n, maxSum, expected)
        }
    }
}

fun MaximumNumberOfIntegersToChooseFromRange1.test(banned: IntArray, n: Int, maxSum: Int, expected: Int) {
    val actual = maxCount(banned, n, maxSum)
    assertEquals(expected, actual)
}
