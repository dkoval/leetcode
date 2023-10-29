package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/poor-pigs/">Poor Pigs</a>
 * <p>
 * There are buckets buckets of liquid, where exactly one of the buckets is poisonous. To figure out which one is poisonous,
 * you feed some number of (poor) pigs the liquid to see whether they will die or not.
 * Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.
 * <p>
 * You can feed the pigs according to these steps:
 * <ul>
 *  <li>Choose some live pigs to feed.</li>
 *  <li>For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time.</li>
 *  <li>Wait for minutesToDie minutes. You may not feed any other pigs during this time.</li>
 *  <li>After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.</li>
 *  <li>Repeat this process until you run out of time.</li>
 * </ul>
 * Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= buckets <= 1000</li>
 *  <li>1 <= minutesToDie <= minutesToTest <= 100</li>
 * </ul>
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // the number of tests we can perform in total
        int tests = minutesToTest / minutesToDie;

        // with a single pig we can check up to (T + 1) buckets, where T is the number of test we can perform:
        // G, G, ..., G, P
        // k buckets are "good", whereas the last one is poisonous

        // use pigs independently to compute x - the minimum number of pigs needed to check N buckets
        // (T + 1) * (T + 1) * ... * (T + 1) = N
        // <------------ x times ---------->
        //
        // (T + 1) ^ x = N
        // x * log(T + 1) = log(N)
        // x = log(N) / log(T + 1)
        return (int) Math.ceil(Math.log(buckets) / Math.log(tests + 1));
    }
}
