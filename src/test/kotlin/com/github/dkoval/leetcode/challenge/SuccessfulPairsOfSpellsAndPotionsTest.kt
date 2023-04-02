package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SuccessfulPairsOfSpellsAndPotions.SuccessfulPairsOfSpellsAndPotionsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SuccessfulPairsOfSpellsAndPotionsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 1, 3),
                intArrayOf(1, 2, 3, 4, 5),
                7L,
                intArrayOf(4, 0, 3)
            ),
            Arguments.of(
                intArrayOf(3, 1, 2),
                intArrayOf(8, 5, 8),
                16L,
                intArrayOf(2, 0, 2)
            ),
            Arguments.of(
                intArrayOf(15, 8, 19),
                intArrayOf(38, 36, 23),
                328L,
                intArrayOf(3, 0, 3),
            )
        )
    }

    @Nested
    inner class SuccessfulPairsOfSpellsAndPotionsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an integer array pairs of length n where pairs(i) is the number of potions that will form a successful pair with the ith spell`(
            spells: IntArray,
            potions: IntArray,
            success: Long,
            expected: IntArray
        ) {
            SuccessfulPairsOfSpellsAndPotionsRev1().test(spells, potions, success, expected)
        }
    }
}

private fun SuccessfulPairsOfSpellsAndPotionsRev1.test(
    spells: IntArray,
    potions: IntArray,
    success: Long,
    expected: IntArray
) {
    val actual = successfulPairs(spells, potions, success)
    assertArrayEquals(expected, actual)
}
