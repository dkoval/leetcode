package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/keys-and-rooms/">Keys and Rooms</a>
 * <p>
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room
 * may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 * where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == rooms.length</li>
 *  <li>2 <= n <= 1000</li>
 *  <li>0 <= rooms[i].length <= 1000</li>
 *  <li>1 <= sum(rooms[i].length) <= 3000</li>
 *  <li>0 <= rooms[i][j] < n</li>
 *  <li>All the values of rooms[i] are unique</li>
 * </ul>
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int currRoomIdx, Set<Integer> visited) {
        for (Integer nextRoomIdx : rooms.get(currRoomIdx)) {
            if (!visited.contains(nextRoomIdx)) {
                visited.add(nextRoomIdx);
                dfs(rooms, nextRoomIdx, visited);
            }
        }
    }
}
