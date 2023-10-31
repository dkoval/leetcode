package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindOriginalArrayOfPrefixXor.FindOriginalArrayOfPrefixXorRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindOriginalArrayOfPrefixXorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 2, 0, 3, 1),
                intArrayOf(5, 7, 2, 3, 2)
            ),
            Arguments.of(
                intArrayOf(13),
                intArrayOf(13)
            )
        )
    }

    @Nested
    inner class FindOriginalArrayOfPrefixXorRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should the array arr of size n that satisfies the condition`(pref: IntArray, expected: IntArray) {
            FindOriginalArrayOfPrefixXorRev1().test(pref, expected)
        }
    }
}

private fun FindOriginalArrayOfPrefixXor.test(pref: IntArray, expected: IntArray) {
    val actual = findArray(pref)
    assertArrayEquals(expected, actual)
}
