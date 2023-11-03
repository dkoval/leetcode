package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BuildArrayWithStackOperations.BuildArrayWithStackOperationsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BuildArrayWithStackOperationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3),
                3,
                arrayOf("Push", "Push", "Pop", "Push")
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                3,
                arrayOf("Push", "Push", "Push")
            ),
            Arguments.of(
                intArrayOf(1, 2),
                4,
                arrayOf("Push", "Push")
            )
        )
    }

    @Nested
    inner class BuildArrayWithStackOperationsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the stack operations needed to build target`(
            target: IntArray,
            n: Int,
            expected: Array<String>
        ) {
            BuildArrayWithStackOperationsRev1().test(target, n, expected)
        }
    }
}

private fun BuildArrayWithStackOperationsRev1.test(
    target: IntArray,
    n: Int,
    expected: Array<String>
) {
    val actual = buildArray(target, n)
    assertEquals(expected, actual)
}
