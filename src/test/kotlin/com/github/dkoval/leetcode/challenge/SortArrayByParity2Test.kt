package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SortArrayByParity2.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortArrayByParity2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 5, 7)
            ),
            Arguments.of(
                intArrayOf(2, 3)
            ),
            Arguments.of(
                intArrayOf(648,831,560,986,192,424,997,829,897,843)
            )
        )
    }

    @Nested
    inner class SortArrayByParity2UsingTwoQueuesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort the array so that whenever nums(i) is odd, i is odd, and whenever nums(i) is even, i is even`(
            nums: IntArray
        ) {
            SortArrayByParity2UsingTwoQueues().test(nums)
        }
    }

    @Nested
    inner class SortArrayByParity2InplaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort the array so that whenever nums(i) is odd, i is odd, and whenever nums(i) is even, i is even`(
            nums: IntArray
        ) {
            SortArrayByParity2Inplace().test(nums)
        }
    }

    @Nested
    inner class SortArrayByParity2InplaceUsingTwoPointersTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should sort the array so that whenever nums(i) is odd, i is odd, and whenever nums(i) is even, i is even`(
            nums: IntArray
        ) {
            SortArrayByParity2InplaceUsingTwoPointers().test(nums)
        }
    }

    private fun SortArrayByParity2.test(nums: IntArray) {
        val actual = sortArrayByParityII(nums)
        println(actual.contentToString())
        assertThat(actual).`is`(
            Condition(
                { arr -> arr.withIndex().all { (idx, num) -> (idx % 2) == (num % 2) } },
                "index i and nums[i] have the same parity"
            )
        )
    }
}