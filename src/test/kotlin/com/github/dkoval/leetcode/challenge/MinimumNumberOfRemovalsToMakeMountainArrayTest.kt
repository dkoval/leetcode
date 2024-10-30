package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

internal class MinimumNumberOfRemovalsToMakeMountainArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 1),
                0
            ),
            Arguments.of(
                intArrayOf(2, 1, 1, 5, 6, 2, 3, 1),
                3
            )
        )
    }
}