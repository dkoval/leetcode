package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DestroyingAsteroids.DestroyingAsteroidsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class DestroyingAsteroidsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                10,
                intArrayOf(3, 9, 19, 5, 21),
                true
            ),
            Arguments.of(
                5,
                intArrayOf(4, 9, 23, 4),
                false
            )
        )
    }

    @Nested
    inner class DestroyingAsteroidsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if all asteroids can be destroyed`(mass: Int, asteroids: IntArray, expected: Boolean) {
            DestroyingAsteroidsRev1().test(mass, asteroids, expected)
        }
    }
}

private fun DestroyingAsteroids.test(mass: Int, asteroids: IntArray, expected: Boolean) {
    val actual = asteroidsDestroyed(mass, asteroids)
    assertEquals(expected, actual)
}
