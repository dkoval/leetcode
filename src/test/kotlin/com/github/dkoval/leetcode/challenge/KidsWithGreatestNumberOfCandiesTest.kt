package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KidsWithGreatestNumberOfCandies.KidsWithGreatestNumberOfCandiesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KidsWithGreatestNumberOfCandiesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 5, 1, 3),
                3,
                listOf(true, true, true, false, true)
            ),
            Arguments.of(
                intArrayOf(4, 2, 1, 1, 2),
                1,
                listOf(true, false, false, false, false)
            ),
            Arguments.of(
                intArrayOf(12, 1, 12),
                10,
                listOf(true, false, true)
            )
        )
    }

    @Nested
    inner class KidsWithGreatestNumberOfCandiesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a boolean array result of length n, where result(i) is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids`(
            candies: IntArray,
            extraCandies: Int,
            expected: List<Boolean>
        ) {
            KidsWithGreatestNumberOfCandiesRev1().test(candies, extraCandies, expected)
        }
    }
}

private fun KidsWithGreatestNumberOfCandies.test(candies: IntArray, extraCandies: Int, expected: List<Boolean>) {
    val actual = kidsWithCandies(candies, extraCandies)
    assertEquals(expected, actual)
}
