package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimizedMaximumOfProductsDistributedToAnyStore.MinimizedMaximumOfProductsDistributedToAnyStoreRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimizedMaximumOfProductsDistributedToAnyStoreTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                6,
                intArrayOf(11, 6),
                3
            ),
            Arguments.of(
                7,
                intArrayOf(15, 10, 10),
                5
            ),
            Arguments.of(
                1,
                intArrayOf(100000),
                100000
            )
        )
    }

    @Nested
    inner class MinimizedMaximumOfProductsDistributedToAnyStoreRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should minimize the maximum number of products distributed to any store`(
            n: Int,
            quantities: IntArray,
            expected: Int
        ) {
            MinimizedMaximumOfProductsDistributedToAnyStoreRev1().test(n, quantities, expected)
        }
    }
}

private fun MinimizedMaximumOfProductsDistributedToAnyStore.test(n: Int, quantities: IntArray, expected: Int) {
    val actual = minimizedMaximum(n, quantities)
    assertEquals(expected, actual)
}
