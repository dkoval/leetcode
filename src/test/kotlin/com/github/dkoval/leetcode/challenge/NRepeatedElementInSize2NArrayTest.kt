package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NRepeatedElementInSize2NArray.NRepeatedElementInSize2NArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NRepeatedElementInSize2NArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 3),
                3
            ),
            Arguments.of(
                intArrayOf(2, 1, 2, 5, 3, 2),
                2
            ),
            Arguments.of(
                intArrayOf(5, 1, 5, 2, 5, 3, 5, 4),
                5
            )
        )
    }

    @Nested
    inner class NRepeatedElementInSize2NArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the repeated element`(arr: IntArray, expected: Int) {
            NRepeatedElementInSize2NArrayRev1().test(arr, expected)
        }
    }
}

private fun NRepeatedElementInSize2NArrayRev1.test(arr: IntArray, expected: Int) {
    val actual = repeatedNTimes(arr)
    assertEquals(expected, actual)
}
