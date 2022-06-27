package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.mock.TimeNeededToInformAllEmployees.TimeNeededToInformAllEmployeesBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class TimeNeededToInformAllEmployeesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                0,
                intArrayOf(-1),
                intArrayOf(0),
                0
            ),
            Arguments.of(
                6,
                2,
                intArrayOf(2, 2, -1, 2, 2, 2),
                intArrayOf(0, 0, 1, 0, 0, 0),
                1
            )
        )
    }

    @Nested
    inner class TimeNeededToInformAllEmployeesDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of minutes needed to inform all the employees about the urgent news`(
            n: Int,
            headID: Int,
            manager: IntArray,
            informTime: IntArray,
            expected: Int
        ) {
            TimeNeededToInformAllEmployeesBFS().test(n, headID, manager, informTime, expected)
        }
    }

    @Nested
    inner class TimeNeededToInformAllEmployeesBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of minutes needed to inform all the employees about the urgent news`(
            n: Int,
            headID: Int,
            manager: IntArray,
            informTime: IntArray,
            expected: Int
        ) {
            TimeNeededToInformAllEmployeesBFS().test(n, headID, manager, informTime, expected)
        }
    }

    private fun TimeNeededToInformAllEmployees.test(
        n: Int,
        headID: Int,
        manager: IntArray,
        informTime: IntArray,
        expected: Int
    ) {
        val actual = numOfMinutes(n, headID, manager, informTime)
        assertEquals(expected, actual)
    }
}