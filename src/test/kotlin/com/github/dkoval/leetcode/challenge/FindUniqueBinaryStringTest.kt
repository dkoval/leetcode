package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindUniqueBinaryString.FindUniqueBinaryStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindUniqueBinaryStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("01", "10"),
                "00"
            ),
            Arguments.of(
                arrayOf("00", "01"),
                "10"
            ),
            Arguments.of(
                arrayOf("111", "011", "001"),
                "000"
            )
        )
    }

    @Nested
    inner class FindUniqueBinaryStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a binary string of length n that does not appear in nums`(
            nums: Array<String>,
            expected: String
        ) {
            FindUniqueBinaryStringRev1().test(nums, expected)
        }
    }
}

private fun FindUniqueBinaryString.test(nums: Array<String>, expected: String) {
    val actual = findDifferentBinaryString(nums)
    assertEquals(expected, actual)
}
