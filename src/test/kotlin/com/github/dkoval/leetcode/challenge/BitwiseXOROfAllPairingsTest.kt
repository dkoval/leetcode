package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BitwiseXOROfAllPairings.BitwiseXOROfAllPairingsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BitwiseXOROfAllPairingsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(contexts: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3),
                intArrayOf(10, 2, 5, 0),
                13
            ),
            Arguments.of(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                0
            )
        )
    }

    @Nested
    inner class BitwiseXOROfAllPairingsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the bitwise XOR of all integers in nums3`(nums1: IntArray, nums2: IntArray, expected: Int) {
            BitwiseXOROfAllPairingsRev1().test(nums1, nums2, expected)
        }
    }
}

private fun BitwiseXOROfAllPairings.test(nums1: IntArray, nums2: IntArray, expected: Int) {
    val actual = xorAllNums(nums1, nums2)
    assertEquals(expected, actual)
}
