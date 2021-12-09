package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.JumpGame3.JumpGame3DFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class JumpGame3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 3, 0, 3, 1, 2),
                5,
                true
            ),
            Arguments.of(
                intArrayOf(4, 2, 3, 0, 3, 1, 2),
                0,
                true
            ),
            Arguments.of(
                intArrayOf(3, 0, 2, 1, 2),
                2,
                false
            )
        )
    }

    @Nested
    inner class JumpGame3DFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check check if you can reach to any index with value 0`(
            arr: IntArray,
            start: Int,
            expected: Boolean
        ) {
            JumpGame3DFS().test(arr, start, expected)
        }
    }

    private fun JumpGame3.test(arr: IntArray, start: Int, expected: Boolean) {
        val actual = canReach(arr, start)
        assertEquals(expected, actual)
    }
}