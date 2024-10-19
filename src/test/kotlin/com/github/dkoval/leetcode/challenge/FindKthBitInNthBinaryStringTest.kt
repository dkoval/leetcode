package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindKthBitInNthBinaryString.FindKthBitInNthBinaryStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindKthBitInNthBinaryStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 1, "0"),
            Arguments.of(4, 11, "1")
        )
    }

    @Nested
    inner class FindKthBitInNthBinaryStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the kth bit in Sn`(n: Int, k: Int, expected: Int) {
            FindKthBitInNthBinaryStringRev1().test(n, k, expected)
        }
    }
}

private fun FindKthBitInNthBinaryString.test(n: Int, k: Int, expected: Int) {
    val actual = findKthBit(n, k)
    assertEquals(expected, actual)
}
