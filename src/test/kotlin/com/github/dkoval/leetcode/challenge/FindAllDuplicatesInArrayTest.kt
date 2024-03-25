package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindAllDuplicatesInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 3, 2, 7, 8, 2, 3, 1),
                listOf(2, 3)
            ),
            Arguments.of(
                intArrayOf(1, 1, 2),
                listOf(1)
            ),
            Arguments.of(
                intArrayOf(1),
                listOf<Int>()
            )
        )
    }

    @Nested
    inner class FindAllDuplicatesInArrayRev1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all the elements that appear twice in an array`(nums: IntArray, expected: List<Int>) {
            FindAllDuplicatesInArrayRev1.test(nums, expected)
        }
    }
}

private fun FindAllDuplicatesInArray.test(nums: IntArray, expected: List<Int>) {
    val actual = findDuplicates(nums)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
