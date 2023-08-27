package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/frog-jump/">Frog Jump (Hard)</a>
 * <p>
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone.
 * Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= stones.length <= 2000</li>
 *  <li>0 <= stones[i] <= 2^31 - 1</li>
 *  <li>stones[0] == 0</li>
 *  <li>stones is sorted in a strictly increasing order</li>
 * </ul>
 */
public interface FrogJump {

    boolean canCross(int[] stones);

    class FrogJumpDPTopDown implements FrogJump {

        @Override
        public boolean canCross(int[] stones) {
            int n = stones.length;

            Map<Integer, Integer> indices = new HashMap<>();
            for (int i = 1; i < n; i++) {
                indices.put(stones[i], i);
            }

            return canJump(stones, indices, 0, 1, new HashMap<>());
        }

        // can jump to the last stone from the i-th stone?
        private boolean canJump(int[] stones, Map<Integer, Integer> indices, int index, int jump, Map<Key, Boolean> dp) {
            int n = stones.length;

            // base case
            if (index == n - 1) {
                return true;
            }

            // already solved?
            Key key = new Key(index, jump);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            boolean possible = false;
            // 1st jump must be 1 unit
            int[] offsets = (index == 0) ? new int[]{0} : new int[]{-1, 0, 1};
            for (int offset : offsets) {
                int nextJump = jump + offset;
                if (nextJump == 0) {
                    continue;
                }

                int nextDest = stones[index] + nextJump;
                if (indices.containsKey(nextDest)) {
                    int nextIndex = indices.get(nextDest);
                    possible |= canJump(stones, indices, nextIndex, nextJump, dp);
                    if (possible) {
                        break;
                    }
                }
            }

            dp.put(key, possible);
            return possible;
        }

        private static class Key {
            final int index;
            final int jump;

            Key(int index, int jump) {
                this.index = index;
                this.jump = jump;
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || o.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) o;
                return (index == that.index) && (jump == that.jump);
            }

            public int hashCode() {
                return Objects.hash(index, jump);
            }
        }
    }
}
