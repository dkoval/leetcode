package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountOfInterestingSubarrays.CountOfInterestingSubarraysRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountOfInterestingSubarraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(3, 2, 4),
                2,
                1,
                3L
            ),
            Arguments.of(
                listOf(3, 1, 9, 6),
                3,
                0,
                2L
            )
        )
    }

    @Nested
    inner class CountOfInterestingSubarraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of interesting subarrays`(
            nums: List<Int>,
            modulo: Int,
            k: Int,
            expected: Long
        ) {
            CountOfInterestingSubarraysRev1().test(nums, modulo, k, expected)
        }
    }
}

private fun CountOfInterestingSubarrays.test(
    nums: List<Int>,
    modulo: Int,
    k: Int,
    expected: Long
) {
    val actual = countInterestingSubarrays(nums, modulo, k)
    assertEquals(expected, actual)
}
