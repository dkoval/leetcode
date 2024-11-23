package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RotatingBox.RotatingBoxRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RotatingBoxTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('#', '.', '#')
                ),
                arrayOf(
                    charArrayOf('.'),
                    charArrayOf('#'),
                    charArrayOf('#')
                )
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('#', '.', '*', '.'),
                    charArrayOf('#', '#', '*', '.')
                ),
                arrayOf(
                    charArrayOf('#', '.'),
                    charArrayOf('#', '#'),
                    charArrayOf('*', '*'),
                    charArrayOf('.', '.')
                )
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf('#', '#', '*', '.', '*', '.'),
                    charArrayOf('#', '#', '#', '*', '.', '.'),
                    charArrayOf('#', '#', '#', '.', '#', '.')
                ),
                arrayOf(
                    charArrayOf('.', '#', '#'),
                    charArrayOf('.', '#', '#'),
                    charArrayOf('#', '#', '*'),
                    charArrayOf('#', '*', '.'),
                    charArrayOf('#', '.', '*'),
                    charArrayOf('#', '.', '.')
                )
            )
        )
    }

    @Nested
    inner class RotatingBoxRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should matrix representing the box after the rotation`(box: Array<CharArray>, expected: Array<CharArray>) {
            RotatingBoxRev1().test(box, expected)
        }
    }
}

private fun RotatingBox.test(box: Array<CharArray>, expected: Array<CharArray>) {
    val actual = rotateTheBox(box)
    assertArrayEquals(expected, actual)
}
