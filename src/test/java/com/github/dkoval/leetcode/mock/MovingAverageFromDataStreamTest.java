package com.github.dkoval.leetcode.mock;

import com.github.dkoval.leetcode.mock.MovingAverageFromDataStream.MovingAverage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovingAverageFromDataStreamTest {

    public static List<Arguments> input() {
        return Collections.singletonList(
                Arguments.of(
                        3,
                        new int[]{1, 10, 3, 5},
                        new double[]{1.0, (1.0 + 10) / 2, (1.0 + 10 + 3) / 3, (10.0 + 3 + 5) / 3}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    public void shouldReturnMovingAverage(int size, int[] stream, double[] expected) {
        MovingAverage solution = new MovingAverage(size);
        double[] actual = new double[stream.length];
        for (int i = 0; i < stream.length; i++) {
            actual[i] = solution.next(stream[i]);
        }
        assertArrayEquals(expected, actual, 1E-6);
    }
}