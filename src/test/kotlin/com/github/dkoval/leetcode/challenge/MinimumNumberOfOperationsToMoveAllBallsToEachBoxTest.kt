package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMoveAllBallsToEachBox.MinimumNumberOfOperationsToMoveAllBallsToEachBoxRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfOperationsToMoveAllBallsToEachBoxTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "110",
                intArrayOf(1, 1, 3)
            ),
            Arguments.of(
                "001011",
                intArrayOf(11, 8, 5, 4, 3, 4)
            )
        )
    }

    @Nested
    inner class MinimumNumberOfOperationsToMoveAllBallsToEachBoxRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array answer of size n, where i-th answer is the minimum number of operations needed to move all the balls to the ith box`(
            boxes: String,
            expected: IntArray
        ) {
            MinimumNumberOfOperationsToMoveAllBallsToEachBoxRev1().test(boxes, expected)
        }
    }
}

private fun MinimumNumberOfOperationsToMoveAllBallsToEachBox.test(boxes: String, expected: IntArray) {
    val actual = minOperations(boxes)
    assertArrayEquals(expected, actual)
}
