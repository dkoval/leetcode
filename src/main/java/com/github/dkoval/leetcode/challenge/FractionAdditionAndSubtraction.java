package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/fraction-addition-and-subtraction/">Fraction Addition and Subtraction</a>
 * <p>
 * Given a string expression representing an expression of fraction addition and subtraction, return the calculation
 * result in string format.
 * <p>
 * The final result should be an irreducible fraction. If your final result is an integer, change it to the format of
 * a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The input string only contains '0' to '9', '/', '+' and '-'. So does the output.</li>
 *  <li>Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output
 *  is positive, then '+' will be omitted.
 *  </li>
 *  <li>The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will
 *  always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction
 *  format defined above.
 *  </li>
 *  <li>The number of given fractions will be in the range [1, 10].</li>
 *  <li>The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.</li>
 * </ul>
 */
public interface FractionAdditionAndSubtraction {

    String fractionAddition(String expression);

    class FractionAdditionAndSubtractionRev1 implements FractionAdditionAndSubtraction {

        @Override
        public String fractionAddition(String expression) {
            int n = expression.length();

            Fraction ans = Fraction.ZERO;
            int start = 0;
            for (int end = 1; end < n; end++) {
                int c = expression.charAt(end);
                if (c == '+' || c == '-') {
                    ans = ans.add(Fraction.parse(expression.substring(start, end)));
                    start = end;
                }
            }
            // corner case: handle last fraction
            ans = ans.add(Fraction.parse(expression.substring(start)));
            return ans.toString();
        }

        private record Fraction(int p, int q) {
            static final Fraction ZERO = new Fraction(0, 1);

            Fraction(int p, int q) {
                int gcd = gcd(Math.abs(p), q);
                this.p = p / gcd;
                this.q = q / gcd;
            }

            static Fraction parse(String text) {
                String[] tokens = text.split("/");
                return new Fraction(
                        Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]));
            }

            private int gcd(int a, int b) {
                if (b == 0) {
                    return a;
                }
                return gcd(b, a % b);
            }

            Fraction add(Fraction that) {
                // p1 / q1 + p2 / q2 = (p1 * q2 + p2 * q1) / q1 * q2
                return new Fraction(p * that.q + that.p * q, q * that.q);
            }

            @Override
            public String toString() {
                return String.valueOf(p) + '/' + q;
            }
        }
    }
}
