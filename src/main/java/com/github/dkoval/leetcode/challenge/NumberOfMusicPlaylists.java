package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/number-of-music-playlists/">Number of Music Playlists (Hard)</a>
 * <p>
 * Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during your trip.
 * To avoid boredom, you will create a playlist so that:
 * <ul>
 *  <li>Every song is played at least once.</li>
 *  <li>A song can only be played again only if k other songs have been played.</li>
 * </ul>
 * Given n, goal, and k, return the number of possible playlists that you can create.
 * Since the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <p>
 * 0 <= k < n <= goal <= 100
 */
public interface NumberOfMusicPlaylists {

    int MOD = 1_000_000_007;

    int numMusicPlaylists(int n, int goal, int k);

    class NumberOfMusicPlaylistsDPTopDown implements NumberOfMusicPlaylists {

        @Override
        public int numMusicPlaylists(int n, int goal, int k) {
            // Idea: DP top-down
            return calculate(n, k, goal, 0, new HashMap<>());
        }

        private int calculate(int n, int k, int goal, int playedSongs, Map<Key, Integer> dp) {
            if (goal == 0) {
                return (playedSongs == n) ? 1 : 0;
            }

            // already solved?
            Key key = new Key(goal, playedSongs);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            // option #1: add a new song
            // n = 5
            // already played songs: [1, 2]
            // possible new songs to play next: [3, 4, 5]
            long count = (long)(n - playedSongs) * calculate(n, k, goal - 1, playedSongs + 1, dp);
            count %= MOD;

            // option #2: add an already played song
            // k = 3
            // already played songs: [1, 2, 3, 4, 5]
            //                              <-----> k = 3
            // songs that can be re-played again: [1, 2]
            if (playedSongs - k > 0) {
                count += (long)(playedSongs - k) * calculate(n, k, goal - 1, playedSongs, dp);
                count %= MOD;
            }

            // cache and return the answer
            int ans = (int) count;
            dp.put(key, ans);
            return ans;
        }

        private static class Key {
            final int x1;
            final int x2;

            Key(int x1, int x2) {
                this.x1 = x1;
                this.x2 = x2;
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || o.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) o;
                return (x1 == that.x1) && (x2 == that.x2);
            }

            public int hashCode() {
                return Objects.hash(x1, x2);
            }
        }
    }
}
