package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.HandOfStraights.HandOfStraightsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HandOfStraightsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8),
                3,
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                false
            )
        )
    }

    @Nested
    inner class HandOfStraightsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if cards can be rearranged to form consecutive groups, or false otherwise`(
            hand: IntArray,
            groupSize: Int,
            expected: Boolean
        ) {
            HandOfStraightsRev1().test(hand, groupSize, expected)
        }
    }
}

private fun HandOfStraights.test(hand: IntArray, groupSize: Int, expected: Boolean) {
    val actual = isNStraightHand(hand, groupSize)
    assertEquals(expected, actual)
}
