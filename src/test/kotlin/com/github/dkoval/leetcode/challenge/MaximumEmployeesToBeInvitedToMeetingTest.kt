package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumEmployeesToBeInvitedToMeeting.MaximumEmployeesToBeInvitedToMeetingRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumEmployeesToBeInvitedToMeetingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 2, 1, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 2, 0),
                3
            ),
            Arguments.of(
                intArrayOf(3, 0, 1, 4, 1),
                4
            )
        )
    }

    @Nested
    inner class MaximumEmployeesToBeInvitedToMeetingRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of employees that can be invited to the meeting`(
            favorite: IntArray,
            expected: Int
        ) {
            MaximumEmployeesToBeInvitedToMeetingRev1().test(favorite, expected)
        }
    }
}

private fun MaximumEmployeesToBeInvitedToMeeting.test(favorite: IntArray, expected: Int) {
    val actual = maximumInvitations(favorite)
    assertEquals(expected, actual)
}
