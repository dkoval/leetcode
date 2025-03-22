package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindAllPossibleRecipesFromGivenSupplies.FindAllPossibleRecipesFromGivenSuppliesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindAllPossibleRecipesFromGivenSuppliesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("bread"),
                listOf(
                    listOf("yeast", "flour")
                ),
                arrayOf("yeast", "flour", "corn"),
                arrayOf("bread")
            ),
            Arguments.of(
                arrayOf("bread", "sandwich"),
                listOf(
                    listOf("yeast", "flour"),
                    listOf("bread", "meat")
                ),
                arrayOf("yeast", "flour", "meat"),
                arrayOf("bread", "sandwich")
            ),
            Arguments.of(
                arrayOf("bread", "sandwich", "burger"),
                listOf(
                    listOf("yeast", "flour"),
                    listOf("bread", "meat"),
                    listOf("sandwich", "meat", "bread")
                ),
                arrayOf("yeast", "flour", "meat"),
                arrayOf("bread", "sandwich", "burger")
            ),
            Arguments.of(
                arrayOf("bread"),
                listOf(
                    listOf("yeast", "flour")
                ),
                arrayOf("yeast"),
                emptyArray<String>()
            ),
            Arguments.of(
                arrayOf("ju", "fzjnm", "x", "e", "zpmcz", "h", "q"),
                listOf(
                    listOf("d"),
                    listOf("hveml", "f", "cpivl"),
                    listOf("cpivl", "zpmcz", "h", "e", "fzjnm", "ju"),
                    listOf("cpivl", "hveml", "zpmcz", "ju", "h"),
                    listOf("h", "fzjnm", "e", "q", "x"),
                    listOf("d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x"),
                    listOf("f", "hveml", "cpivl")
                ),
                arrayOf("f", "hveml", "cpivl", "d"),
                arrayOf("ju", "fzjnm", "q")
            )
        )
    }

    @Nested
    inner class FindAllPossibleRecipesFromGivenSuppliesTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of all the recipes that you can create in any order`(
            recipes: Array<String>,
            ingredients: List<List<String>>,
            supplies: Array<String>,
            expected: Array<String>
        ) {
            FindAllPossibleRecipesFromGivenSuppliesRev1().test(recipes, ingredients, supplies, expected)
        }
    }
}

private fun FindAllPossibleRecipesFromGivenSupplies.test(
    recipes: Array<String>,
    ingredients: List<List<String>>,
    supplies: Array<String>,
    expected: Array<String>
) {
    val actual = findAllRecipes(recipes, ingredients, supplies)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
