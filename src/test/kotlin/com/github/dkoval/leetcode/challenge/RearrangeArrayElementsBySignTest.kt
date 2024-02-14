package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RearrangeArrayElementsBySign.RearrangeArrayElementsBySignRev1
import com.github.dkoval.leetcode.challenge.RearrangeArrayElementsBySign.RearrangeArrayElementsBySignRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RearrangeArrayElementsBySignTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1, -2, -5, 2, -4),
                intArrayOf(3, -2, 1, -5, 2, -4)
            ),
            Arguments.of(
                intArrayOf(-1, 1),
                intArrayOf(1, -1)
            )
        )
    }

    @Nested
    inner class RearrangeArrayElementsBySignRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the modified array after rearranging the elements to satisfy the conditions`(
            nums: IntArray,
            expected: IntArray
        ) {
            RearrangeArrayElementsBySignRev1().test(nums, expected)
        }
    }

    @Nested
    inner class RearrangeArrayElementsBySignRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the modified array after rearranging the elements to satisfy the conditions`(
            nums: IntArray,
            expected: IntArray
        ) {
            RearrangeArrayElementsBySignRev2().test(nums, expected)
        }
    }
}

private fun RearrangeArrayElementsBySign.test(nums: IntArray, expected: IntArray) {
    val actual = rearrangeArray(nums)
    assertArrayEquals(expected, actual)
}
