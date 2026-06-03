package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.EarliestFinishTimeForLandAndWaterRides2.EarliestFinishTimeForLandAndWaterRides2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class EarliestFinishTimeForLandAndWaterRides2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 8),
                intArrayOf(4, 1),
                intArrayOf(6),
                intArrayOf(3),
                9
            ),
            Arguments.of(
                intArrayOf(5),
                intArrayOf(3),
                intArrayOf(1),
                intArrayOf(10),
                14
            )
        )
    }

    @Nested
    inner class EarliestFinishTimeForLandAndWaterRides2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the earliest possible time at which the tourist can finish both rides`(
            landStartTime: IntArray,
            landDuration: IntArray,
            waterStartTime: IntArray,
            waterDuration: IntArray,
            expected: Int
        ) {
            EarliestFinishTimeForLandAndWaterRides2Rev1().test(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration,
                expected
            )
        }
    }
}

private fun EarliestFinishTimeForLandAndWaterRides2.test(
    landStartTime: IntArray,
    landDuration: IntArray,
    waterStartTime: IntArray,
    waterDuration: IntArray,
    expected: Int
) {
    val actual = earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration)
    assertEquals(expected, actual)
}
