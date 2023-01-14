package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LexicographicallySmallestEquivalentString.LexicographicallySmallestEquivalentStringRev1
import com.github.dkoval.leetcode.challenge.LexicographicallySmallestEquivalentString.LexicographicallySmallestEquivalentStringRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LexicographicallySmallestEquivalentStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "parker",
                "morris",
                "parser",
                "makkek"
            ),
            Arguments.of(
                "hello",
                "world",
                "hold",
                "hdld"
            ),
            Arguments.of(
                "leetcode",
                "programs",
                "sourcecode",
                "aauaaaaada"
            ),
            Arguments.of(
                "aabbbabbbbbabbbbaabaabbaaabbbabaababaaaabbbbbabbaa",
                "aabbaabbbabaababaabaababbbababbbaaaabbbbbabbbaabaa",
                "buqpqxmnajphtisernebttymtrydomxnwonfhfjlzzrfhosjct",
                "auqpqxmnajphtiserneattymtrydomxnwonfhfjlzzrfhosjct"
            ),
            Arguments.of(
                "dccaccbdafgeabeeghbigbhicggfbhiccfgbechdicbhdcgahi",
                "igfcigeciahdafgegfbeddhgbacaeehcdiehiifgbhhehhccde",
                "sanfbzzwblekirguignnfkpzgqjmjmfokrdfuqbgyflpsfpzbo",
                "sanaazzwalakarauaannakpzaqjmjmaokraauqaayalpsapzao"
            )
        )
    }

    @Nested
    inner class LexicographicallySmallestEquivalentStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2`(
            s1: String,
            s2: String,
            baseStr: String,
            expected: String
        ) {
            LexicographicallySmallestEquivalentStringRev1().test(s1, s2, baseStr, expected)
        }
    }

    @Nested
    inner class LexicographicallySmallestEquivalentStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2`(
            s1: String,
            s2: String,
            baseStr: String,
            expected: String
        ) {
            LexicographicallySmallestEquivalentStringRev2().test(s1, s2, baseStr, expected)
        }
    }

    private fun LexicographicallySmallestEquivalentString.test(
        s1: String,
        s2: String,
        baseStr: String,
        expected: String
    ) {
        val actual = smallestEquivalentString(s1, s2, baseStr)
        assertEquals(expected, actual)
    }
}
