package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TakingMaximumEnergyFromMysticDungeon.TakingMaximumEnergyFromMysticDungeonRev1
import com.github.dkoval.leetcode.challenge.TakingMaximumEnergyFromMysticDungeon.TakingMaximumEnergyFromMysticDungeonRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TakingMaximumEnergyFromMysticDungeonTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 2, -10, -5, 1),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(-2, -3, -1),
                2,
                -1
            )
        )
    }

    @Nested
    inner class TakingMaximumEnergyFromMysticDungeonRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should the maximum possible energy you can gain`(
            energy: IntArray,
            k: Int,
            expected: Int
        ) {
            TakingMaximumEnergyFromMysticDungeonRev1().test(energy, k, expected)
        }
    }

    @Nested
    inner class TakingMaximumEnergyFromMysticDungeonRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should the maximum possible energy you can gain`(
            energy: IntArray,
            k: Int,
            expected: Int
        ) {
            TakingMaximumEnergyFromMysticDungeonRev2().test(energy, k, expected)
        }
    }
}

private fun TakingMaximumEnergyFromMysticDungeon.test(energy: IntArray, k: Int, expected: Int) {
    val actual = maximumEnergy(energy, k)
    assertEquals(expected, actual)
}
