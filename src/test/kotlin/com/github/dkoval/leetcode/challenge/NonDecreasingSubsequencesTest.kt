package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NonDecreasingSubsequences.NonDecreasingSubsequencesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NonDecreasingSubsequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 6, 7, 7),
                listOf(
                    listOf(4, 6, 7, 7),
                    listOf(4, 6, 7),
                    listOf(4, 6),
                    listOf(4, 7, 7),
                    listOf(4, 7),
                    listOf(6, 7, 7),
                    listOf(6, 7),
                    listOf(7, 7)
                )
            ),
            Arguments.of(
                intArrayOf(4, 4, 3, 2, 1),
                listOf(
                    listOf(4, 4)
                )
            ),
            Arguments.of(
                intArrayOf(100, 90, 80, 70, 60, 50, 60, 70, 80, 90, 100),
                listOf(
                    listOf(100, 100),
                    listOf(90, 90, 100),
                    listOf(90, 90),
                    listOf(90, 100),
                    listOf(80, 80, 90, 100),
                    listOf(80, 80, 90),
                    listOf(80, 80, 100),
                    listOf(80, 80),
                    listOf(80, 90, 100),
                    listOf(80, 90),
                    listOf(80, 100),
                    listOf(70, 70, 80, 90, 100),
                    listOf(70, 70, 80, 90),
                    listOf(70, 70, 80, 100),
                    listOf(70, 70, 80),
                    listOf(70, 70, 90, 100),
                    listOf(70, 70, 90),
                    listOf(70, 70, 100),
                    listOf(70, 70),
                    listOf(70, 80, 90, 100),
                    listOf(70, 80, 90),
                    listOf(70, 80, 100),
                    listOf(70, 80),
                    listOf(70, 90, 100),
                    listOf(70, 90),
                    listOf(70, 100),
                    listOf(60, 60, 70, 80, 90, 100),
                    listOf(60, 60, 70, 80, 90),
                    listOf(60, 60, 70, 80, 100),
                    listOf(60, 60, 70, 80),
                    listOf(60, 60, 70, 90, 100),
                    listOf(60, 60, 70, 90),
                    listOf(60, 60, 70, 100),
                    listOf(60, 60, 70),
                    listOf(60, 60, 80, 90, 100),
                    listOf(60, 60, 80, 90),
                    listOf(60, 60, 80, 100),
                    listOf(60, 60, 80),
                    listOf(60, 60, 90, 100),
                    listOf(60, 60, 90),
                    listOf(60, 60, 100),
                    listOf(60, 60),
                    listOf(60, 70, 80, 90, 100),
                    listOf(60, 70, 80, 90),
                    listOf(60, 70, 80, 100),
                    listOf(60, 70, 80),
                    listOf(60, 70, 90, 100),
                    listOf(60, 70, 90),
                    listOf(60, 70, 100),
                    listOf(60, 70),
                    listOf(60, 80, 90, 100),
                    listOf(60, 80, 90),
                    listOf(60, 80, 100),
                    listOf(60, 80),
                    listOf(60, 90, 100),
                    listOf(60, 90),
                    listOf(60, 100),
                    listOf(50, 60, 70, 80, 90, 100),
                    listOf(50, 60, 70, 80, 90),
                    listOf(50, 60, 70, 80, 100),
                    listOf(50, 60, 70, 80),
                    listOf(50, 60, 70, 90, 100),
                    listOf(50, 60, 70, 90),
                    listOf(50, 60, 70, 100),
                    listOf(50, 60, 70),
                    listOf(50, 60, 80, 90, 100),
                    listOf(50, 60, 80, 90),
                    listOf(50, 60, 80, 100),
                    listOf(50, 60, 80),
                    listOf(50, 60, 90, 100),
                    listOf(50, 60, 90),
                    listOf(50, 60, 100),
                    listOf(50, 60),
                    listOf(50, 70, 80, 90, 100),
                    listOf(50, 70, 80, 90),
                    listOf(50, 70, 80, 100),
                    listOf(50, 70, 80),
                    listOf(50, 70, 90, 100),
                    listOf(50, 70, 90),
                    listOf(50, 70, 100),
                    listOf(50, 70),
                    listOf(50, 80, 90, 100),
                    listOf(50, 80, 90),
                    listOf(50, 80, 100),
                    listOf(50, 80),
                    listOf(50, 90, 100),
                    listOf(50, 90),
                    listOf(50, 100)
                )
            )
        )
    }

    @Nested
    inner class NonDecreasingSubsequencesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all the different possible non-decreasing subsequences of the given array with at least two elements`(
            nums: IntArray,
            expected: List<List<Int>>
        ) {
            NonDecreasingSubsequencesRev1().test(nums, expected)
        }
    }

    private fun NonDecreasingSubsequences.test(nums: IntArray, expected: List<List<Int>>) {
        val ans = findSubsequences(nums)
        assertThat(ans).containsExactlyInAnyOrderElementsOf(expected)
    }
}