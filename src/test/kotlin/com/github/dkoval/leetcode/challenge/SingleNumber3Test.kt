package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SingleNumber3.SingleNumber3Rev2
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
                intArrayOf(3, 5),
            ),
            Arguments.of(
                intArrayOf(-1, 0),
                intArrayOf(-1, 0)
            ),
            Arguments.of(
                intArrayOf(0, 1),
                intArrayOf(1, 0)
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
    inner class SingleNumber3Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the two elements that appear only once`(nums: IntArray, expected: IntArray) {
            SingleNumber3Rev1.test(nums, expected)
        }
    }

    @Nested
    inner class SingleNumber3Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the two elements that appear only once`(nums: IntArray, expected: IntArray) {
            SingleNumber3Rev2().test(nums, expected)
        }
    }
}

private fun SingleNumber3.test(nums: IntArray, expected: IntArray) {
    val actual = singleNumber(nums)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
