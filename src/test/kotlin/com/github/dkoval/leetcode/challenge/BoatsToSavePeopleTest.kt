package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BoatsToSavePeople.BoatsToSavePeopleRev1
import com.github.dkoval.leetcode.challenge.BoatsToSavePeople.BoatsToSavePeopleRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BoatsToSavePeopleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2),
                3,
                1
            ),
            Arguments.of(
                intArrayOf(3, 2, 2, 1),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(3, 5, 3, 4),
                5,
                4
            ),
            Arguments.of(
                intArrayOf(5, 1, 4, 2),
                6,
                2
            )
        )
    }

    @Nested
    inner class BoatsToSavePeopleRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the minimum number of boats to carry every given person`(
            people: IntArray,
            limit: Int,
            expected: Int
        ) {
            BoatsToSavePeopleRev1().test(people, limit, expected)
        }
    }

    @Nested
    inner class BoatsToSavePeopleRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return the minimum number of boats to carry every given person`(
            people: IntArray,
            limit: Int,
            expected: Int
        ) {
            BoatsToSavePeopleRev2().test(people, limit, expected)
        }
    }
}

private fun BoatsToSavePeople.test(people: IntArray, limit: Int, expected: Int) {
    val actual = numRescueBoats(people, limit)
    assertEquals(expected, actual)
}
