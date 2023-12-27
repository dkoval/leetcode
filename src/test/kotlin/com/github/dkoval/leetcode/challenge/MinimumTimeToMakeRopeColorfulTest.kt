package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumTimeToMakeRopeColorful.MinimumTimeToMakeRopeColorfulRev1
import com.github.dkoval.leetcode.challenge.MinimumTimeToMakeRopeColorful.MinimumTimeToMakeRopeColorfulRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumTimeToMakeRopeColorfulTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abaac",
                intArrayOf(1, 2, 3, 4, 5),
                3
            ),
            Arguments.of(
                "abc",
                intArrayOf(1, 2, 3),
                0
            ),
            Arguments.of(
                "aabaa",
                intArrayOf(1, 2, 3, 4, 1),
                2
            )
        )
    }

    @Nested
    inner class MinimumTimeToMakeRopeColorfulRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time to make the rope colorful`(
            colors: String,
            neededTime: IntArray,
            expected: Int
        ) {
            MinimumTimeToMakeRopeColorfulRev1().test(colors, neededTime, expected)
        }
    }

    @Nested
    inner class MinimumTimeToMakeRopeColorfulRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum time to make the rope colorful`(
            colors: String,
            neededTime: IntArray,
            expected: Int
        ) {
            MinimumTimeToMakeRopeColorfulRev2().test(colors, neededTime, expected)
        }
    }
}

private fun MinimumTimeToMakeRopeColorful.test(colors: String, neededTime: IntArray, expected: Int) {
    val actual = minCost(colors, neededTime)
    assertEquals(expected, actual)
}
