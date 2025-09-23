package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CompareVersionNumbers.CompareVersionNumbersRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CompareVersionNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "0.1",
                "1.1",
                -1
            ),
            Arguments.of(
                "1.0.1",
                "1",
                1
            ),
            Arguments.of(
                "7.5.2.4",
                "7.5.3",
                -1
            ),
            Arguments.of(
                "1.01",
                "1.001",
                0 // Ignoring leading zeroes, both “01” and “001" represent the same number “1”
            ),
            Arguments.of(
                "1.0",
                "1.0.0",
                0 // The first version number does not have a third level revision number, which means its third level revision number is default to "0"
            ),
            Arguments.of(
                "1.05",
                "1.1",
                1
            )
        )
    }

    @Nested
    inner class CompareVersionNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compare version`(version1: String, version2: String, expected: Int) {
            CompareVersionNumbersRev1.test(version1, version2, expected)
        }
    }

    @Nested
    inner class CompareVersionNumbersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compare version`(version1: String, version2: String, expected: Int) {
            CompareVersionNumbersRev2().test(version1, version2, expected)
        }
    }

    @Nested
    inner class CompareVersionNumbersOldSchoolTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compare version`(version1: String, version2: String, expected: Int) {
            CompareVersionNumbersOldSchool().test(version1, version2, expected)
        }
    }
}

private fun CompareVersionNumbers.test(version1: String, version2: String, expected: Int) {
    val actual = compareVersion(version1, version2)
    assertEquals(expected, actual)
}
