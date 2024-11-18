package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DefuseBomb.DefuseBombRev1
import com.github.dkoval.leetcode.challenge.DefuseBomb.DefuseBombRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DefuseBombTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 7, 1, 4),
                3,
                intArrayOf(12, 10, 16, 13)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                0,
                intArrayOf(0, 0, 0, 0)
            ),
            Arguments.of(
                intArrayOf(2, 4, 9, 3),
                -2,
                intArrayOf(12, 5, 6, 13)
            )
        )
    }

    @Nested
    inner class DefuseBombRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the decrypted code to defuse the bomb`(code: IntArray, k: Int, expected: IntArray) {
            DefuseBombRev1().test(code, k, expected)
        }
    }

    @Nested
    inner class DefuseBombRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the decrypted code to defuse the bomb`(code: IntArray, k: Int, expected: IntArray) {
            DefuseBombRev2().test(code, k, expected)
        }
    }
}

private fun DefuseBomb.test(code: IntArray, k: Int, expected: IntArray) {
    val actual = decrypt(code, k)
    assertArrayEquals(expected, actual)
}
