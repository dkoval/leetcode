package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximizeHappinessOfSelectedChildren.MaximizeHappinessOfSelectedChildrenRev1
import com.github.dkoval.leetcode.challenge.MaximizeHappinessOfSelectedChildren.MaximizeHappinessOfSelectedChildrenRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximizeHappinessOfSelectedChildrenTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1),
                2,
                1
            ),
            Arguments.of(
                intArrayOf(2, 3, 4, 5),
                1,
                5
            ),
            Arguments.of(
                intArrayOf(
                    2135218,
                    73431904,
                    92495076,
                    77528042,
                    82824634,
                    3036629,
                    28375907,
                    65220365,
                    40948869,
                    58914871,
                    57169530,
                    89783499,
                    19582915,
                    19676695,
                    11932465,
                    21770144,
                    49740276,
                    22303751,
                    80746555,
                    97391584,
                    95775653,
                    43396943,
                    47271136,
                    43935930,
                    59643137,
                    64183008,
                    8892641,
                    39587569,
                    85086654,
                    5663585,
                    82925096,
                    24868817,
                    95900395,
                    48155864,
                    74447380,
                    7618448,
                    63299623,
                    91141186,
                    33347112,
                    81951555,
                    52867615,
                    92184410,
                    7024265,
                    85525916,
                    29846922,
                    59532692,
                    47267934,
                    6514603,
                    1137830,
                    97807470
                ),
                41,
                2517853814
            )
        )
    }

    @Nested
    inner class MaximizeHappinessOfSelectedChildrenRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of the happiness values of the selected children you can achieve by selecting k children`(
            happiness: IntArray,
            k: Int,
            expected: Long
        ) {
            MaximizeHappinessOfSelectedChildrenRev1().test(happiness, k, expected)
        }
    }

    @Nested
    inner class MaximizeHappinessOfSelectedChildrenRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of the happiness values of the selected children you can achieve by selecting k children`(
            happiness: IntArray,
            k: Int,
            expected: Long
        ) {
            MaximizeHappinessOfSelectedChildrenRev2().test(happiness, k, expected)
        }
    }
}

private fun MaximizeHappinessOfSelectedChildren.test(happiness: IntArray, k: Int, expected: Long) {
    val actual = maximumHappinessSum(happiness, k)
    assertEquals(expected, actual)
}
