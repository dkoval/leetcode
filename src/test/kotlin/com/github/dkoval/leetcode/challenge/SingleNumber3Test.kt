package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SingleNumber3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 1, 3, 2, 5),
                intArrayOf(3, 5)
            )
        )
    }

    @Nested
    inner class NaiveSingleNumber3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the two elements that appear only once`(nums: IntArray, expected: IntArray) {
            NaiveSingleNumber3.test(nums, expected)
        }
    }

    @Nested
    inner class SmartSingleNumber3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the two elements that appear only once`(nums: IntArray, expected: IntArray) {
            SmartSingleNumber3.test(nums, expected)
        }
    }

    private fun SingleNumber3.test(nums: IntArray, expected: IntArray) {
        val actual = singleNumber(nums)
        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }
}