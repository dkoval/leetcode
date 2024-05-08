package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RelativeRanks.RelativeRanksRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RelativeRanksTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 4, 3, 2, 1),
                arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5")
            ),
            Arguments.of(
                intArrayOf(10, 3, 8, 9, 4),
                arrayOf("Gold Medal", "5", "Bronze Medal", "Silver Medal", "4")
            )
        )
    }

    @Nested
    inner class RelativeRanksRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array answer of size n where answer(i) is the rank of the i-th athlete`(
            score: IntArray,
            expected: Array<String>
        ) {
            RelativeRanksRev1().test(score, expected)
        }
    }
}

private fun RelativeRanks.test(score: IntArray, expected: Array<String>) {
    val actual = findRelativeRanks(score)
    assertArrayEquals(expected, actual)
}
