package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

/**
 * <a href="https://leetcode.com/problems/compare-version-numbers/">Compare Version Numbers</a>
 * <p>
 * Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'.
 * The value of the revision is its integer conversion ignoring leading zeros.
 * <p>
 * To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions,
 * treat the missing revision values as 0.
 * <p>
 * Return the following:
 * <p>
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= version1.length, version2.length <= 500</li>
 *  <li>version1 and version2 only contain digits and '.'.</li>
 *  <li>version1 and version2 are valid version numbers.</li>
 *  <li>All the given revisions in version1 and version2 can be stored in a 32-bit integer.</li>
 * </ul>
 */
public interface CompareVersionNumbers {

    int compareVersion(String version1, String version2);

    class CompareVersionNumbersOldSchool implements CompareVersionNumbers {

        @Override
        public int compareVersion(@NotNull String version1, @NotNull String version2) {
            int rev1Start = 0;
            int rev1End = 0;

            int rev2Start = 0;
            int rev2End = 0;
            while (rev1Start < version1.length() || rev2Start < version2.length()) {
                int rev1 = 0;
                if (rev1Start < version1.length()) {
                    while (rev1End < version1.length() && version1.charAt(rev1End) != '.') {
                        rev1End++;
                    }
                    rev1 = Integer.parseInt(version1.substring(rev1Start, rev1End));
                    rev1Start = ++rev1End;
                }

                int rev2 = 0;
                if (rev2Start < version2.length()) {
                    while (rev2End < version2.length() && version2.charAt(rev2End) != '.') {
                        rev2End++;
                    }
                    rev2 = Integer.parseInt(version2.substring(rev2Start, rev2End));
                    rev2Start = ++rev2End;
                }

                if (rev1 != rev2) {
                    return (rev1 < rev2) ? -1 : 1;
                }
            }
            return 0;
        }
    }

    class CompareVersionNumbersRev2 implements CompareVersionNumbers {

        @Override
        public int compareVersion(String version1, String version2) {
            final var revs1 = version1.split("\\.");
            final var revs2 = version2.split("\\.");

            final var n1 = revs1.length;
            final var n2 = revs2.length;
            for (var i = 0; i < n1 || i < n2; i++) {
                final var rev1 = (i < n1) ? Integer.parseInt(revs1[i]) : 0;
                final var rev2 = (i < n2) ? Integer.parseInt(revs2[i]) : 0;
                if (rev1 == rev2) {
                    continue;
                }
                return rev1 < rev2 ? -1 : 1;
            }
            return 0;
        }
    }
}
