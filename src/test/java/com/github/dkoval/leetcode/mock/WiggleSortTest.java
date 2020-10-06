package com.github.dkoval.leetcode.mock;

import com.github.dkoval.leetcode.mock.WiggleSort.WiggleSortInLinearTime;
import com.github.dkoval.leetcode.mock.WiggleSort.WiggleSortInNLogNTime;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class WiggleSortTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class WiggleSortInNLogNTimeTest {

        List<Arguments> input() {
            return Collections.singletonList(
                    Arguments.of(
                            new int[]{3, 5, 2, 1, 6, 4},
                            new int[]{1, 3, 2, 5, 4, 6}
                    )
            );
        }

        @ParameterizedTest
        @MethodSource("input")
        void verifyRequiredReordering(int[] nums, int[] expected) {
            test(new WiggleSortInNLogNTime(), nums, expected);
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class WiggleSortInLinearTimeTest {

        List<Arguments> input() {
            return Collections.singletonList(
                    Arguments.of(
                            new int[]{3, 5, 2, 1, 6, 4},
                            new int[]{3, 5, 1, 6, 2, 4}
                    )
            );
        }

        @ParameterizedTest
        @MethodSource("input")
        void verifyRequiredReordering(int[] nums, int[] expected) {
            test(new WiggleSortInLinearTime(), nums, expected);
        }

    }

    private static void test(WiggleSort solution, int[] nums, int[] expected) {
        solution.wiggleSort(nums);
        assertArrayEquals(expected, nums);
    }
}