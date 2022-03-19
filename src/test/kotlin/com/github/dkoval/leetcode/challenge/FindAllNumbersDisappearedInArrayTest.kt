package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindAllNumbersDisappearedInArray.FindAllNumbersDisappearedInArrayNoExtraSpace
import com.github.dkoval.leetcode.challenge.FindAllNumbersDisappearedInArray.FindAllNumbersDisappearedInArrayUsingSet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindAllNumbersDisappearedInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 3, 2, 7, 8, 2, 3, 1),
                listOf(5, 6)
            ),
            Arguments.of(
                intArrayOf(1, 1),
                listOf(2)
            )
        )
    }

    @Nested
    inner class FindAllNumbersDisappearedInArrayUsingSetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of all the integers in the range (1, n) that do not appear in nums`(
            nums: IntArray,
            expected: List<Int>
        ) {
            FindAllNumbersDisappearedInArrayUsingSet().test(nums, expected)
        }
    }

    @Nested
    inner class FindAllNumbersDisappearedInArrayNoExtraSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of all the integers in the range (1, n) that do not appear in nums`(
            nums: IntArray,
            expected: List<Int>
        ) {
            FindAllNumbersDisappearedInArrayNoExtraSpace().test(nums, expected)
        }
    }

    private fun FindAllNumbersDisappearedInArray.test(nums: IntArray, expected: List<Int>) {
        val actual = findDisappearedNumbers(nums)
        assertEquals(expected, actual)
    }
}