package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KInversePairsArray.KInversePairsArrayDPBottomUp
import com.github.dkoval.leetcode.challenge.KInversePairsArray.KInversePairsArrayDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KInversePairsArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 0, 1),
            Arguments.of(3, 1, 2)
        )
    }

    @Nested
    inner class KInversePairsArrayDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs`(
            n: Int,
            k: Int,
            expected: Int
        ) {
            KInversePairsArrayDPTopDown().test(n, k, expected)
        }
    }

    @Nested
    inner class KInversePairsArrayDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs`(
            n: Int,
            k: Int,
            expected: Int
        ) {
            KInversePairsArrayDPBottomUp().test(n, k, expected)
        }
    }

    private fun KInversePairsArray.test(n: Int, k: Int, expected: Int) {
        val actual = kInversePairs(n, k)
        assertEquals(expected, actual)
    }
}