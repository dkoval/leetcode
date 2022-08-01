package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/time-based-key-value-store/">Time Based Key-Value Store</a>
 * <p>
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
 * and retrieve the key's value at a certain timestamp.
 * <p>
 * Implement the TimeMap class:
 * <p>
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= key.length, value.length <= 100</li>
 *  <li>key and value consist of lowercase English letters and digits</li>
 *  <li>1 <= timestamp <= 10^7</li>
 *  <li>All the timestamps timestamp of set are strictly increasing</li>
 *  <li>At most 2 * 10^5 calls will be made to set and get</li>
 * </ul>
 */
public abstract class TimeBasedKeyValueStore {

    public static class TimeMap {

        private final Map<String, List<Value>> map = new HashMap<>();

        public TimeMap() {
            // noop
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Value(value, timestamp));
        }

        public String get(String key, int timestamp) {
            String ans = "";
            if (!map.containsKey(key)) {
                return ans;
            }

            // binary search
            // condition x.timestamp <= timestamp eventually becomes False
            // TT...TFF...F
            //      ^ answer (upper bound)
            List<Value> values = map.get(key);
            int left = 0;
            int right = values.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Value x = values.get(mid);
                if (x.timestamp <= timestamp) {
                    // values[mid] might be the answer;
                    // check if there is a better option to the right of mid index
                    ans = x.value;
                    left = mid + 1;
                } else {
                    // values[mid] is not the answer + everything to the right of mid index
                    right = mid - 1;
                }
            }
            return ans;
        }

        private static class Value {
            final String value;
            final int timestamp;

            Value(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }
}
