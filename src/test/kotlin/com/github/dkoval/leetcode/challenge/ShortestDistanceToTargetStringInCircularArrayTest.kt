package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestDistanceToTargetStringInCircularArray.ShortestDistanceToTargetStringInCircularArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ShortestDistanceToTargetStringInCircularArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("hello", "i", "am", "leetcode", "hello"),
                "hello",
                1,
                1
            ),
            Arguments.of(
                arrayOf("a", "b", "leetcode"),
                "leetcode",
                0,
                1
            ),
            Arguments.of(
                arrayOf("i", "eat", "leetcode"),
                "ate",
                0,
                -1
            )
        )
    }

    @Nested
    inner class ShortestDistanceToTargetStringInCircularArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the shortest distance to the target string in circular array`(
            words: Array<String>,
            target: String,
            startIndex: Int,
            expected: Int
        ) {
            ShortestDistanceToTargetStringInCircularArrayRev1().test(words, target, startIndex, expected)
        }
    }
}

private fun ShortestDistanceToTargetStringInCircularArray.test(
    words: Array<String>,
    target: String,
    startIndex: Int,
    expected: Int
) {
    val actual = closestTarget(words, target, startIndex)
    assertEquals(expected, actual)
}
