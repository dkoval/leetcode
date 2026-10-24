package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountDaysSpentTogether.CountDaysSpentTogetherRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CountDaysSpentTogetherTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of("08-15", "08-18", "08-16", "08-19", 3),
            Arguments.of("10-01", "10-31", "11-01", "12-31", 0),
            Arguments.of("09-01", "10-19", "06-19", "10-20", 49)
        )
    }

    @Nested
    inner class CountDaysSpentTogetherRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of days Alice and Bob spend together`(
            arriveAlice: String,
            leaveAlice: String,
            arriveBob: String,
            leaveBob: String,
            expected: Int
        ) {
            CountDaysSpentTogetherRev1().test(arriveAlice, leaveAlice, arriveBob, leaveBob, expected)
        }
    }
}

private fun CountDaysSpentTogetherRev1.test(
    arriveAlice: String,
    leaveAlice: String,
    arriveBob: String,
    leaveBob: String,
    expected: Int
) {
    val actual = countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)
    assertThat(actual).isEqualTo(expected)
}
