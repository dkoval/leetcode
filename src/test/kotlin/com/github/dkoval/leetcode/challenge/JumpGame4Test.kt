package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.JumpGame4.JumpGame4BFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class JumpGame4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404),
                3
            ),
            Arguments.of(
                intArrayOf(7),
                0
            ),
            Arguments.of(
                intArrayOf(7, 6, 9, 6, 9, 6, 9, 7),
                1
            ),
            Arguments.of(
                intArrayOf(6, 1, 9),
                2
            ),
            Arguments.of(
                intArrayOf(11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13),
                3
            )
        )
    }

    @Nested
    inner class JumpGame4BFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of steps to reach the last index of the array`(
            arr: IntArray,
            expected: Int
        ) {
            JumpGame4BFS().test(arr, expected)
        }
    }
}

private fun JumpGame4.test(arr: IntArray, expected: Int) {
    val actual = minJumps(arr)
    assertEquals(expected, actual)
}
