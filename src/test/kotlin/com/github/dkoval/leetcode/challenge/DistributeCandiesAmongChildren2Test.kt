package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DistributeCandiesAmongChildren2.DistributeCandiesAmongChildren2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DistributeCandiesAmongChildren2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(5, 2, 3L),
            Arguments.of(3, 3, 10L),
            Arguments.of(6, 2, 1L)
        )
    }

    @Nested
    inner class DistributeCandiesAmongChildren2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies`(
            n: Int,
            limit: Int,
            expected: Long
        ) {
            DistributeCandiesAmongChildren2Rev1().test(n, limit, expected)
        }
    }

}

private fun DistributeCandiesAmongChildren2Rev1.test(n: Int, limit: Int, expected: Long) {
    val actual = distributeCandies(n, limit)
    assertEquals(expected, actual)
}
