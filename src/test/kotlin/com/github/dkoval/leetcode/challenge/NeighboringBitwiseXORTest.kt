package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NeighboringBitwiseXOR.NeighboringBitwiseXORRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NeighboringBitwiseXORTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 0),
                true
            ),
            Arguments.of(
                intArrayOf(1, 1),
                true
            ),
            Arguments.of(
                intArrayOf(1, 0),
                false
            )
        )
    }

    @Nested
    inner class NeighboringBitwiseXORRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if original array exists`(derived: IntArray, expected: Boolean) {
            NeighboringBitwiseXORRev1().test(derived, expected)
        }
    }
}

private fun NeighboringBitwiseXOR.test(derived: IntArray, expected: Boolean) {
    val actual = doesValidArrayExist(derived)
    assertEquals(expected, actual)
}
