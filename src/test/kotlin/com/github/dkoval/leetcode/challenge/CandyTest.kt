package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Candy.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CandyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 0, 2),
                5
            ),
            Arguments.of(
                intArrayOf(1, 2, 2),
                4
            ),
            Arguments.of(
                intArrayOf(1, 2, 87, 87, 87, 2, 1),
                13
            )
        )
    }

    @Nested
    inner class CandyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of candies you need to have to distribute the candies to the children`(
            ratings: IntArray,
            expected: Int
        ) {
            CandyRev1().test(ratings, expected)
        }
    }

    @Nested
    inner class CandyRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of candies you need to have to distribute the candies to the children`(
            ratings: IntArray,
            expected: Int
        ) {
            CandyRev2().test(ratings, expected)
        }
    }

    @Nested
    inner class CandyRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of candies you need to have to distribute the candies to the children`(
            ratings: IntArray,
            expected: Int
        ) {
            CandyRev3().test(ratings, expected)
        }
    }
}

private fun Candy.test(ratings: IntArray, expected: Int) {
    val actual = candy(ratings)
    assertEquals(expected, actual)
}
