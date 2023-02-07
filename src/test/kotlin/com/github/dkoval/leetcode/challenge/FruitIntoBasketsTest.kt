package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FruitIntoBaskets.FruitIntoBasketsRev1
import com.github.dkoval.leetcode.challenge.FruitIntoBaskets.FruitIntoBasketsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FruitIntoBasketsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 1),
                3
            ),
            Arguments.of(
                intArrayOf(0, 1, 2, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 2, 2),
                4
            ),
            Arguments.of(
                intArrayOf(1, 0, 3, 4, 3),
                3
            )
        )
    }

    @Nested
    inner class FruitIntoBasketsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of fruits you can pick`(fruits: IntArray, expected: Int) {
            FruitIntoBasketsRev1().test(fruits, expected)
        }
    }

    @Nested
    inner class FruitIntoBasketsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of fruits you can pick`(fruits: IntArray, expected: Int) {
            FruitIntoBasketsRev2().test(fruits, expected)
        }
    }
}

private fun FruitIntoBaskets.test(fruits: IntArray, expected: Int) {
    val actual = totalFruit(fruits)
    assertEquals(expected, actual)
}
