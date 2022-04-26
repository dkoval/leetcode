package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">Min Cost to Connect All Points</a>
 * <p>
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * <p>
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * <p>
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= points.length <= 1000</li>
 *  <li>-10^6 <= xi, yi <= 10^6</li>
 *  <li>All pairs (xi, yi) are distinct</li>
 * </ul>
 */
public class MinCostToConnectAllPoints {

    private static class PairOfPoints {
        final int i; // index of the 1st point, i.e. points[i]
        final int j; // index of the 2nd point, i.e. points[j]
        final int distance; // distance between points[i] and points[j]

        PairOfPoints(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    private static class UnionFind {
        // parent[i] is the parent of i
        final int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            // initially, every is the parent to itself
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            parent[px] = py;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);

        // generate all possible pairs of points and sort them by distance
        PriorityQueue<PairOfPoints> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new PairOfPoints(i, j, distance));
            }
        }

        int ans = 0; // the minimum cost to make all points connected
        int numConnectedPoints = 0;
        while (!pq.isEmpty() && numConnectedPoints < n - 1) {
            PairOfPoints pair = pq.poll();
            if (uf.find(pair.i) != uf.find(pair.j)) {
                uf.union(pair.i, pair.j);
                numConnectedPoints++;
                ans += pair.distance;
            }
        }
        return ans;
    }
}
