package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfBalloons.MaximumNumberOfBalloonsUsingSingleMap
import com.github.dkoval.leetcode.challenge.MaximumNumberOfBalloons.MaximumNumberOfBalloonsUsingTwoMaps
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfBalloonsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("nlaebolko", 1),
            Arguments.of("loonbalxballpoon", 2),
            Arguments.of("leetcode", 0)
        )
    }

    @Nested
    inner class MaximumNumberOfBalloonsUsingTwoMapsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of instances of the word 'balloon' that can be formed`(
            text: String,
            expected: Int
        ) {
            MaximumNumberOfBalloonsUsingTwoMaps().test(text, expected)
        }
    }

    @Nested
    inner class MaximumNumberOfBalloonsUsingSingleMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of instances of the word 'balloon' that can be formed`(
            text: String,
            expected: Int
        ) {
            MaximumNumberOfBalloonsUsingSingleMap().test(text, expected)
        }
    }

    private fun MaximumNumberOfBalloons.test(text: String, expected: Int) {
        val actual = maxNumberOfBalloons(text)
        assertEquals(expected, actual)
    }
}