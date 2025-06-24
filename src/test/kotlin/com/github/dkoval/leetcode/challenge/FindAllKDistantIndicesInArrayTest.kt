package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindAllKDistantIndicesInArray.FindAllKDistantIndicesInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindAllKDistantIndicesInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 4, 9, 1, 3, 9, 5),
                9,
                1,
                listOf(1, 2, 3, 4, 5, 6)
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                2,
                2,
                listOf(0, 1, 2, 3, 4)
            )
        )
    }

    @Nested
    inner class FindAllKDistantIndicesInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all k-distant indices in an array`(
            nums: IntArray,
            key: Int,
            k: Int,
            expected: List<Int>
        ) {
            FindAllKDistantIndicesInArrayRev1().test(nums, key, k, expected)
        }
    }
}

private fun FindAllKDistantIndicesInArray.test(nums: IntArray, key: Int, k: Int, expected: List<Int>) {
    val actual = findKDistantIndices(nums, key, k)
    assertEquals(expected, actual)
}
