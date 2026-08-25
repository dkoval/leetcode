package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestMissingMultipleOfK.SmallestMissingMultipleOfKRev1
import com.github.dkoval.leetcode.challenge.SmallestMissingMultipleOfK.SmallestMissingMultipleOfKRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SmallestMissingMultipleOfKTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(8, 2, 3, 4, 6),
                2,
                10
            ),
            Arguments.of(
                intArrayOf(1, 4, 7, 10, 15),
                5,
                5
            ),
        )
    }

    @Nested
    inner class SmallestMissingMultipleOfKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest positive multiple of k that is missing from nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SmallestMissingMultipleOfKRev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class SmallestMissingMultipleOfKRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest positive multiple of k that is missing from nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SmallestMissingMultipleOfKRev2().test(nums, k, expected)
        }
    }
}

private fun SmallestMissingMultipleOfK.test(nums: IntArray, k: Int, expected: Int) {
    val actual = missingMultiple(nums, k)
    assertEquals(expected, actual)
}
