package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortArrayByParity.SortArrayByParityInplaceRev1
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortArrayByParityTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1),
                intArrayOf(1)
            ),
            Arguments.of(
                intArrayOf(2),
                intArrayOf(2)
            ),
            Arguments.of(
                intArrayOf(3, 1, 2, 4),
                intArrayOf(2, 4, 3, 1)
            ),
            Arguments.of(
                intArrayOf(1, 0, 3, 2, 4),
                intArrayOf(2, 4, 3, 1)
            )
        )
    }

    @Nested
    inner class SortArrayByParityNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array consisting of all the even elements of A, followed by all the odd elements of A`(
            nums: IntArray,
            expected: IntArray
        ) {
            SortArrayByParityNaive.test(nums, expected)
        }
    }

    @Nested
    inner class SortArrayByParityInplaceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array consisting of all the even elements of A, followed by all the odd elements of A`(
            nums: IntArray,
            expected: IntArray
        ) {
            SortArrayByParityInplaceRev1().test(nums, expected)
        }
    }

    @Nested
    inner class SortArrayByParityInplaceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array consisting of all the even elements of A, followed by all the odd elements of A`(
            nums: IntArray,
            expected: IntArray
        ) {
            SortArrayByParityInplaceRev2.test(nums, expected)
        }
    }
}

private fun SortArrayByParity.test(nums: IntArray, expected: IntArray) {
    val actual = sortArrayByParity(nums)
    assertAll(
        { assertEquals(expected.size, actual.size) },
        {
            for (i in expected.indices) {
                assertEquals(expected[i] % 2, actual[i] % 2)
            }
        }
    )
}
