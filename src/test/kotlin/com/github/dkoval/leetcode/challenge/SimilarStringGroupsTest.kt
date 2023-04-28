package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SimilarStringGroups.SimilarStringGroupsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SimilarStringGroupsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("tars", "rats", "arts", "star"),
                2
            ),
            Arguments.of(
                arrayOf("omv", "ovm"),
                1
            ),
            Arguments.of(
                arrayOf(
                    "kccomwcgcs",
                    "socgcmcwkc",
                    "sgckwcmcoc",
                    "coswcmcgkc",
                    "cowkccmsgc",
                    "cosgmccwkc",
                    "sgmkwcccoc",
                    "coswmccgkc",
                    "kowcccmsgc",
                    "kgcomwcccs"
                ),
                5
            ),
        )
    }

    @Nested
    inner class SimilarStringGroupsTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of similar string groups`(strs: Array<String>, expected: Int) {
            SimilarStringGroupsRev1().test(strs, expected)
        }
    }
}

private fun SimilarStringGroups.test(strs: Array<String>, expected: Int) {
    val actual = numSimilarGroups(strs)
    assertEquals(expected, actual)
}
