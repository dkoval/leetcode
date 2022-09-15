package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindOriginalArrayFromDoubledArray.FindOriginalArrayFromDoubledArrayUsingSorting
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindOriginalArrayFromDoubledArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4, 2, 6, 8),
                intArrayOf(1, 3, 4)
            ),
            Arguments.of(
                intArrayOf(6, 3, 0, 1),
                intArrayOf()
            ),
            Arguments.of(
                intArrayOf(1),
                intArrayOf()
            )
        )
    }

    @Nested
    inner class FindOriginalArrayFromDoubledArrayUsingSortingTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return original if changed is a doubled array`(changed: IntArray, expected: IntArray) {
            FindOriginalArrayFromDoubledArrayUsingSorting().test(changed, expected)
        }
    }

    private fun FindOriginalArrayFromDoubledArray.test(changed: IntArray, expected: IntArray) {
        val actual = findOriginalArray(changed)
        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }
}