package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumRecolorsToGetKConsecutiveBlackBlocks.MinimumRecolorsToGetKConsecutiveBlackBlocksRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("WBBWWBBWBW", 7, 3),
            Arguments.of("WBWBBBW", 2, 0)
        )
    }

    @Nested
    inner class MinimumRecolorsToGetKConsecutiveBlackBlocksRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks`(
            blocks: String,
            k: Int,
            expected: Int
        ) {
            MinimumRecolorsToGetKConsecutiveBlackBlocksRev1().test(blocks, k, expected)
        }
    }
}

private fun MinimumRecolorsToGetKConsecutiveBlackBlocks.test(blocks: String, k: Int, expected: Int) {
    val actual = minimumRecolors(blocks, k)
    assertEquals(expected, actual)
}
