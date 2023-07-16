package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestSufficientTeam.SmallestSufficientTeamRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SmallestSufficientTeamTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("java", "nodejs", "reactjs"),
                listOf(
                    listOf("java"),
                    listOf("nodejs"),
                    listOf("nodejs", "reactjs"),
                ),
                intArrayOf(0, 2)
            ),
            Arguments.of(
                arrayOf("algorithms", "math", "java", "reactjs", "csharp", "aws"),
                listOf(
                    listOf("algorithms", "math", "java"),
                    listOf("algorithms", "math", "reactjs"),
                    listOf("java", "csharp", "aws"),
                    listOf("reactjs", "csharp"),
                    listOf("csharp", "math"),
                    listOf("aws", "java")
                ),
                intArrayOf(1, 2)
            )
        )
    }

    @Nested
    inner class SmallestSufficientTeamRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return any sufficient team of the smallest possible size, represented by the index of each person`(
            reqSkills: Array<String>,
            people: List<List<String>>,
            expected: IntArray
        ) {
            SmallestSufficientTeamRev1().test(reqSkills, people, expected)
        }
    }
}

private fun SmallestSufficientTeam.test(reqSkills: Array<String>, people: List<List<String>>, expected: IntArray) {
    val actual = smallestSufficientTeam(reqSkills, people)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
