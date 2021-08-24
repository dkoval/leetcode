package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3917/">Complex Number Multiplication</a>
 * <p>
 * A complex number can be represented as a string on the form "real+imaginaryi" where:
 * <ul>
 *  <li>real is the real part and is an integer in the range [-100, 100]</li>
 *  <li>imaginary is the imaginary part and is an integer in the range [-100, 100]</li>
 *  <li>i2 == -1</li>
 * </ul>
 * Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
 */
public class ComplexNumberMultiplication {

    private static class ComplexNumber {
        final int re;
        final int img;

        ComplexNumber(int re, int img) {
            this.re = re;
            this.img = img;
        }

        static ComplexNumber multiply(ComplexNumber x1, ComplexNumber x2) {
            return new ComplexNumber(
                    x1.re * x2.re - x1.img * x2.img,
                    x1.re * x2.img + x2.re * x1.img);
        }
    }

    public String complexNumberMultiply(String num1, String num2) {
        ComplexNumber x1 = parse(num1);
        ComplexNumber x2 = parse(num2);
        ComplexNumber x = ComplexNumber.multiply(x1, x2);
        return x.re + "+" + x.img + "i";
    }

    private ComplexNumber parse(String num) {
        int plusIndex = num.indexOf('+');
        int re = Integer.parseInt(num.substring(0, plusIndex));
        int img = Integer.parseInt(num.substring(plusIndex + 1, num.length() - 1));
        return new ComplexNumber(re, img);
    }
}
