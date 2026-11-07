package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ProcessTasksUsingServers.ProcessTasksUsingServersRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ProcessTasksUsingServersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(3, 3, 2),
                intArrayOf(1, 2, 3, 2, 1, 2),
                intArrayOf(2, 2, 0, 2, 1, 2)
            ),
            arguments(
                intArrayOf(5, 1, 4, 3, 2),
                intArrayOf(2, 1, 2, 4, 5, 2, 1),
                intArrayOf(1, 4, 1, 4, 1, 3, 2)
            ),
            arguments(
                intArrayOf(10, 63, 95, 16, 85, 57, 83, 95, 6, 29, 71),
                intArrayOf(70, 31, 83, 15, 32, 67, 98, 65, 56, 48, 38, 90, 5),
                intArrayOf(8, 0, 3, 9, 5, 1, 10, 6, 4, 2, 7, 9, 0)
            )
        )
    }

    @Nested
    inner class ProcessTasksUsingServersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should process tasks using servers`(servers: IntArray, tasks: IntArray, expected: IntArray) {
            ProcessTasksUsingServersRev1().test(servers, tasks, expected)
        }
    }
}

private fun ProcessTasksUsingServersRev1.test(
    servers: IntArray,
    tasks: IntArray,
    expected: IntArray
) {
    val actual = assignTasks(servers, tasks)
    assertThat(actual).isEqualTo(expected)
}
