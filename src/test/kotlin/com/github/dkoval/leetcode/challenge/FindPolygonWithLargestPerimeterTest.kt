package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindPolygonWithLargestPerimeter.FindPolygonWithLargestPerimeterRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class FindPolygonWithLargestPerimeterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 5, 5),
                15L
            ),
            Arguments.of(
                intArrayOf(1, 12, 1, 2, 5, 50, 3),
                12L
            ),
            Arguments.of(
                intArrayOf(5, 5, 50),
                -1
            ),
            Arguments.of(
                intArrayOf(
                    300005055,
                    352368231,
                    311935527,
                    315829776,
                    327065463,
                    388851949,
                    319541150,
                    397875604,
                    311309167,
                    391897750,
                    366860048,
                    359976490,
                    325522439,
                    390648914,
                    359891976,
                    369105322,
                    350430086,
                    398592583,
                    354559219,
                    372400239,
                    344759294,
                    379931363,
                    308829137,
                    335032174,
                    336962933,
                    380797651,
                    378305476,
                    336617902,
                    393487098,
                    301391791,
                    394314232,
                    387440261,
                    316040738,
                    388074503,
                    396614889,
                    331609633,
                    374723367,
                    380418460,
                    349845809,
                    318514711,
                    308782485,
                    308291996,
                    375362898,
                    397542455,
                    397628325,
                    392446446,
                    368662132,
                    378781533,
                    372327607,
                    378737987
                ),
                17876942274
            )
        )
    }

    @Nested
    inner class FindPolygonWithLargestPerimeterRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if it is not possible to create a polygon`(
            nums: IntArray,
            expected: Long
        ) {
            FindPolygonWithLargestPerimeterRev1().test(nums, expected)
        }
    }
}

private fun FindPolygonWithLargestPerimeter.test(nums: IntArray, expected: Long) {
    val actual = largestPerimeter(nums)
    assertEquals(expected, actual)
}
