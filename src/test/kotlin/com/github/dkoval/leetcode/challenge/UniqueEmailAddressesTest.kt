package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class UniqueEmailAddressesTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                arrayOf(
                    "test.email+alex@leetcode.com",
                    "test.e.mail+bob.cathy@leetcode.com",
                    "testemail+david@lee.tcode.com"
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    "a@leetcode.com",
                    "b@leetcode.com",
                    "c@leetcode.com"
                ),
                3
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the number of different addresses that actually receive mails`(
        emails: Array<String>,
        expected: Int
    ) {
        val actual = UniqueEmailAddresses().numUniqueEmails(emails)
        assertEquals(expected, actual)
    }
}