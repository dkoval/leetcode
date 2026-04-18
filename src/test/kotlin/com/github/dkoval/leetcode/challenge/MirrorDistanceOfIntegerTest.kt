package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MirrorDistanceOfInteger.MirrorDistanceOfIntegerRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MirrorDistanceOfIntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                25,
                27
            ),
            Arguments.of(
                10,
                9
            ),
            Arguments.of(
                7,
                0
            )
        )
    }

    @Nested
    inner class MirrorDistanceOfIntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the mirror distance of an integer`(
            num: Int,
            expected: Int
        ) {
            MirrorDistanceOfIntegerRev1().test(num, expected)
        }
    }
}

private fun MirrorDistanceOfInteger.test(num: Int, expected: Int) {
    val actual = mirrorDistance(num)
    assertEquals(expected, actual)
}
