package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class CompareVersionNumbersOldSchool implements CompareVersionNumbers{

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
