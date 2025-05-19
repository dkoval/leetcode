package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/type-of-triangle/">Type of Triangle</a>
 * <p>
 * You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.
 * <ul>
 *  <li>A triangle is called equilateral if it has all sides of equal length.</li>
 *  <li>A triangle is called isosceles if it has exactly two sides of equal length.</li>
 *  <li>A triangle is called scalene if all its sides are of different lengths.</li>
 * <ul>
 * Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
 * <p>
 * Constraints:
 * <ul>
 *  <li>nums.length == 3</li>
 *  <li>1 <= nums[i] <= 100</li>
 * </ul>
 */
public interface TypeOfTriangle {

    String triangleType(int[] nums);

    class TypeOfTriangleRev1 implements TypeOfTriangle {

        @Override
        public String triangleType(int[] nums) {
            final var a = nums[0];
            final var b = nums[1];
            final var c = nums[2];

            if (a + b <= c || a + c <= b || b + c <= a) {
                return "none";
            }

            if (a == b && b == c) {
                return "equilateral";
            }

            if (a == b || a == c || b == c) {
                return "isosceles";
            }

            return "scalene";
        }
    }
}
