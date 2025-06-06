package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TypeOfTriangle.TypeOfTriangleRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TypeOfTriangleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 3, 3),
                "equilateral"
            ),
            Arguments.of(
                intArrayOf(3, 4, 5),
                "scalene"
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                "equilateral"
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                "none"
            )
        )
    }

    @Nested
    inner class TypeOfTriangleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the type of triangle`(
            sides: IntArray,
            expected: String
        ) {
            TypeOfTriangleRev1().test(sides, expected)
        }
    }
}

private fun TypeOfTriangle.test(nums: IntArray, expected: String) {
    val actual = triangleType(nums)
    assertEquals(expected, actual)
}
