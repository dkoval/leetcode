package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ImageOverlap.ImageOverlapRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ImageOverlapTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 1, 0)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 0, 1)
                ),
                3 // We translate img1 to right by 1 unit and down by 1 unit.
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1)
                ),
                arrayOf(
                    intArrayOf(1)
                ),
                1
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                arrayOf(
                    intArrayOf(0)
                ),
                0
            )
        )
    }

    @Nested
    inner class ImageOverlapRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest possible overlap`(img1: Array<IntArray>, img2: Array<IntArray>, expected: Int) {
            ImageOverlapRev1().test(img1, img2, expected)
        }
    }

    @Nested
    inner class ImageOverlapRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the largest possible overlap`(img1: Array<IntArray>, img2: Array<IntArray>, expected: Int) {
            ImageOverlapRev2.test(img1, img2, expected)
        }
    }

    private fun ImageOverlap.test(img1: Array<IntArray>, img2: Array<IntArray>, expected: Int) {
        val actual = largestOverlap(img1, img2)
        assertEquals(expected, actual)
    }
}