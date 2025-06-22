package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivideStringIntoGroupsOfSizeK.DivideStringIntoGroupsOfSizeKRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DivideStringIntoGroupsOfSizeKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("abcdefghi", 3, 'x', arrayOf("abc", "def", "ghi")),
            Arguments.of("abcdefghij", 3, 'x', arrayOf("abc", "def", "ghi", "jxx"))
        )
    }

    @Nested
    inner class DivideStringIntoGroupsOfSizeKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should divide the string into groups of size k`(s: String, k: Int, fill: Char, expected: Array<String>) {
            DivideStringIntoGroupsOfSizeKRev1().test(s, k, fill, expected)
        }
    }
}

private fun DivideStringIntoGroupsOfSizeK.test(s: String, k: Int, fill: Char, expected: Array<String>) {
    val actual = divideString(s, k, fill)
    assertArrayEquals(expected, actual)
}
