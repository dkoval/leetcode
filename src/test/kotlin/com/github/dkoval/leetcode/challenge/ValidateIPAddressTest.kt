package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ValidateIPAddressTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("172.16.254.1", "IPv4"),
            Arguments.of("172.16.254.01", "Neither"),
            Arguments.of("256.256.256.256", "Neither"),
            Arguments.of("2001:0db8:85a3:0000:0000:8a2e:0370:7334", "IPv6"),
            Arguments.of("2001:0db8:85a3:0:0:8A2E:0370:7334", "IPv6"),
            Arguments.of("02001:0db8:85a3:0000:0000:8a2e:0370:7334", "Neither"),
            Arguments.of("2001:0db8:85a3::8A2E:0370:7334", "Neither")
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate IP address`(IP: String, expected: String) {
        val actual = ValidateIPAddress.validIPAddress(IP)
        assertEquals(expected, actual)
    }
}