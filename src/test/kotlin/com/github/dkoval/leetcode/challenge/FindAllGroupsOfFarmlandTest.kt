package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindAllGroupsOfFarmland.FindAllGroupsOfFarmlandDFS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindAllGroupsOfFarmlandTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 1, 1)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(1, 1, 2, 2)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ),
                arrayOf(
                    intArrayOf(0, 0, 1, 1)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0)
                ),
                arrayOf<IntArray>()
            )
        )
    }

    @Nested
    inner class FindAllGroupsOfFarmlandDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a 2D array containing the 4-length arrays described above for each group of farmland in land`(
            land: Array<IntArray>,
            expected: Array<IntArray>
        ) {
            FindAllGroupsOfFarmlandDFS().test(land, expected)
        }
    }
}

private fun FindAllGroupsOfFarmland.test(land: Array<IntArray>, expected: Array<IntArray>) {
    val actual = findFarmland(land)
    assertThat(actual.asIterable()).containsExactlyInAnyOrder(*expected)
}
