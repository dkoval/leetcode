package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CriticalConnectionsInNetwork.CriticalConnectionsInNetworkUsingTarjan
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CriticalConnectionsInNetworkTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                listOf(
                    listOf(0, 1),
                    listOf(1, 2),
                    listOf(2, 0),
                    listOf(1, 3)
                ),
                listOf(
                    listOf(1, 3)
                )
            ),
            Arguments.of(
                2,
                listOf(
                    listOf(0, 1)
                ),
                listOf(
                    listOf(0, 1)
                )
            ),
            Arguments.of(
                10,
                listOf(
                    listOf(1, 0),
                    listOf(2, 0),
                    listOf(3, 0),
                    listOf(4, 1),
                    listOf(5, 3),
                    listOf(6, 1),
                    listOf(7, 2),
                    listOf(8, 1),
                    listOf(9, 6),
                    listOf(9, 3),
                    listOf(3, 2),
                    listOf(4, 2),
                    listOf(7, 4),
                    listOf(6, 2),
                    listOf(8, 3),
                    listOf(4, 0),
                    listOf(8, 6),
                    listOf(6, 5),
                    listOf(6, 3),
                    listOf(7, 5),
                    listOf(8, 0),
                    listOf(8, 5),
                    listOf(5, 4),
                    listOf(2, 1),
                    listOf(9, 5),
                    listOf(9, 7),
                    listOf(9, 4),
                    listOf(4, 3)
                ),
                emptyList<List<Int>>()
            )
        )
    }

    @Nested
    inner class CriticalConnectionsInNetworkUsingTarjanTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all critical connections in the network in any order`(
            n: Int,
            connections: List<List<Int>>,
            expected: List<List<Int>>
        ) {
            CriticalConnectionsInNetworkUsingTarjan().test(n, connections, expected)
        }
    }

    private fun CriticalConnectionsInNetwork.test(n: Int, connections: List<List<Int>>, expected: List<List<Int>>) {
        val actual = criticalConnections(n, connections)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}