package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GroupPeopleGivenGroupSizeTheyBelongTo.GroupPeopleGivenGroupSizeTheyBelongToRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GroupPeopleGivenGroupSizeTheyBelongToTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 3, 3, 3, 3, 1, 3),
                listOf(
                    listOf(5),
                    listOf(0, 1, 2),
                    listOf(3, 4, 6)
                )
            ),
            Arguments.of(
                intArrayOf(2, 1, 3, 3, 3, 2),
                listOf(
                    listOf(1),
                    listOf(0, 5),
                    listOf(2, 3, 4)
                )
            )
        )
    }

    @Nested
    inner class GroupPeopleGivenGroupSizeTheyBelongToRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of groups such that each person i is in a group of size groupSizes(i)`(
            groupSizes: IntArray,
            expected: List<List<Int>>
        ) {
            GroupPeopleGivenGroupSizeTheyBelongToRev1().test(groupSizes, expected)
        }
    }
}

private fun GroupPeopleGivenGroupSizeTheyBelongTo.test(groupSizes: IntArray, expected: List<List<Int>>) {
    val actual = groupThePeople(groupSizes)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
