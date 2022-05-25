package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RussianDollEnvelopes.RussianDollEnvelopesTLE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RussianDollEnvelopesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(5, 4),
                    intArrayOf(6, 4),
                    intArrayOf(6, 7),
                    intArrayOf(2, 3)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ),
                1
            )
        )
    }

    @Nested
    inner class RussianDollEnvelopesTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of envelopes you can Russian doll`(
            envelopes: Array<IntArray>,
            expected: Int
        ) {
            RussianDollEnvelopesTLE().maxEnvelopes(envelopes)
        }
    }

    private fun RussianDollEnvelopes.test(envelopes: Array<IntArray>, expected: Int) {
        val actual = maxEnvelopes(envelopes)
        assertEquals(expected, actual)
    }
}