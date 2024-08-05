package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KthDistinctStringInArray.KthDistinctStringInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KthDistinctStringInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("d", "b", "c", "b", "c", "a"),
                2,
                "a"
            ),
            Arguments.of(
                arrayOf("aaa", "aa", "a"),
                1,
                "aaa"
            ),
            Arguments.of(
                arrayOf("a", "b", "a"),
                3,
                ""
            )
        )
    }

    @Nested
    inner class KthDistinctStringInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the kth distinct string present in arr`(arr: Array<String>, k: Int, expected: String) {
            KthDistinctStringInArrayRev1().test(arr, k, expected)
        }
    }
}

private fun KthDistinctStringInArray.test(arr: Array<String>, k: Int, expected: String) {
    val actual = kthDistinct(arr, k)
    assertEquals(expected, actual)
}
