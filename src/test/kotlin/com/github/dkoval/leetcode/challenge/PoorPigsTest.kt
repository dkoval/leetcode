package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PoorPigs.PoorPigsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PoorPigsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(4, 15, 15, 2),
            Arguments.of(4, 15, 30, 2),
            Arguments.of(125, 1, 4, 3),
            Arguments.of(1, 1, 1, 0),
            Arguments.of(1000, 15, 60, 5)
        )
    }

    @Nested
    inner class PoorPigsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time`(
            buckets: Int,
            minutesToDie: Int,
            minutesToTest: Int,
            expected: Int
        ) {
            PoorPigsRev1().test(buckets, minutesToDie, minutesToTest, expected)
        }
    }
}

private fun PoorPigs.test(buckets: Int, minutesToDie: Int, minutesToTest: Int, expected: Int) {
    val actual = poorPigs(buckets, minutesToDie, minutesToTest)
    assertEquals(expected, actual)
}
