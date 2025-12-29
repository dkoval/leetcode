package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PyramidTransitionMatrix.PyramidTransitionMatrixRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PyramidTransitionMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "BCD",
                listOf("BCC", "CDE", "CEA", "FFF"),
                true
            ),
            Arguments.of(
                "AAAA",
                listOf("AAB", "AAC", "BCD", "BBE", "DEF"),
                false
            )
        )
    }

    @Nested
    inner class PyramidTransitionMatrixRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check f you can build the pyramid all the way to the top`(
            bottom: String,
            allowed: List<String>,
            expected: Boolean
        ) {
            PyramidTransitionMatrixRev1().test(bottom, allowed, expected)
        }
    }
}

private fun PyramidTransitionMatrix.test(
    bottom: String,
    allowed: List<String>,
    expected: Boolean
) {
    val actual = pyramidTransition(bottom, allowed)
    assertEquals(expected, actual)
}
