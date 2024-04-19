package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StampingTheSequence.StampingTheSequenceRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StampingTheSequenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abc",
                "ababc",
                intArrayOf(0, 2)
            ),
            Arguments.of(
                "abca",
                "aabcaca",
                intArrayOf(0, 3, 1)
            )
        )
    }

    @Nested
    inner class StampingTheSequenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the index of the left-most letter being stamped at each turn`(
            stamp: String,
            target: String,
            expected: IntArray
        ) {
            StampingTheSequenceRev1().test(stamp, target, expected)
        }
    }
}

private fun StampingTheSequence.test(stamp: String, target: String, expected: IntArray) {
    val actual = movesToStamp(stamp, target)
    assertThat(actual).containsExactly(*expected)
}
