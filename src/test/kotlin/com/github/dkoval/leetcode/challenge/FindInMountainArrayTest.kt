package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindInMountainArray.FindInMountainArrayRev1
import com.github.dkoval.leetcode.challenge.FindInMountainArray.MountainArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindInMountainArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 3, 1),
                3,
                2
            ),
            Arguments.of(
                intArrayOf(0, 1, 2, 4, 2, 1),
                3,
                -1
            )
        )
    }

    @Nested
    inner class FindInMountainArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find in mountain array`(arr: IntArray, target: Int, expected: Int) {
            FindInMountainArrayRev1().test(arr, target, expected)
        }
    }
}

private fun FindInMountainArray.test(arr: IntArray, target: Int, expected: Int) {
    val actual = findInMountainArray(target, MountainArray.of(arr))
    assertEquals(expected, actual)
}
