package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindLuckyIntegerInArray.FindLuckyIntegerInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindLuckyIntegerInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 2, 3, 4),
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 2, 3, 3, 3),
                3
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 3, 3),
                -1
            )
        )
    }

    @Nested
    inner class FindLuckyIntegerInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lucky integer`(
            arr: IntArray,
            expected: Int
        ) {
            FindLuckyIntegerInArrayRev1().test(arr, expected)
        }
    }
}

private fun FindLuckyIntegerInArray.test(arr: IntArray, expected: Int) {
    val actual = findLucky(arr)
    assertEquals(expected, actual)
}
