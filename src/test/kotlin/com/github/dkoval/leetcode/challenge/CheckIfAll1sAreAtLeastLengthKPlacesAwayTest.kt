package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfAll1sAreAtLeastLengthKPlacesAway.CheckIfAll1sAreAtLeastLengthKPlacesAwayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfAll1sAreAtLeastLengthKPlacesAwayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 0, 0, 0, 1, 0, 0, 1),
                2,
                true
            ),
            Arguments.of(
                intArrayOf(1, 0, 0, 1, 0, 1),
                2,
                false
            ),
            Arguments.of(
                intArrayOf(0, 0, 0),
                2,
                true
            )
        )
    }

    @Nested
    inner class CheckIfAll1sAreAtLeastLengthKPlacesAwayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if all 1's are at least length k places away from each other`(
            nums: IntArray,
            k: Int,
            expected: Boolean
        ) {
            CheckIfAll1sAreAtLeastLengthKPlacesAwayRev1().test(nums, k, expected)
        }
    }
}

private fun CheckIfAll1sAreAtLeastLengthKPlacesAway.test(nums: IntArray, k: Int, expected: Boolean) {
    val actual = kLengthApart(nums, k)
    assertEquals(expected, actual)
}
