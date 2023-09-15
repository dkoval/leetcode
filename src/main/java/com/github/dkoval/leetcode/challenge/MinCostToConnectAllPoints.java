package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
public interface MinCostToConnectAllPoints {

    int minCostConnectPoints(int[][] points);

    class MinCostToConnectAllPointsUsingUnionFindRev1 implements MinCostToConnectAllPoints {

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

            boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px != py) {
                    parent[px] = py;
                    return true;
                }
                return false;
            }
        }

        @Override
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

            // Kruskal's algorithm
            int cost = 0;
            int numConnectedPoints = 0;
            while (!pq.isEmpty() && numConnectedPoints < n - 1) {
                PairOfPoints pair = pq.poll();
                if (uf.union(pair.i, pair.j)) {
                    numConnectedPoints++;
                    cost += pair.distance;
                }
            }
            return cost;
        }
    }

    class MinCostToConnectAllPointsUsingUnionFindRev2 implements MinCostToConnectAllPoints {

        @Override
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(new Edge(i, j, dist));
                }
            }

            // calculate Minimum Spanning Tree - Kruskal's algorithm
            edges.sort(Comparator.comparingInt(edge -> edge.weight));

            int cost = 0;
            UnionFind uf = new UnionFind(n);
            int numConnected = 0;
            for (Edge edge : edges) {
                if (uf.union(edge.p1, edge.p2)) {
                    cost += edge.weight;
                    if (++numConnected == n - 1) {
                        break;
                    }
                }
            }
            return cost;
        }

        private static class Edge {
            final int p1;
            final int p2;
            final int weight;

            Edge (int p1, int p2, int weight) {
                this.p1 = p1;
                this.p2 = p2;
                this.weight = weight;
            }
        }

        private static class UnionFind {
            final int[] parent;

            UnionFind(int n) {
                parent = new int[n];
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

            boolean union(int a, int b) {
                int pa = find(a);
                int pb = find(b);
                if (pa != pb) {
                    parent[pa] = pb;
                    return true;
                }
                return false;
            }
        }
    }

    class MinCostToConnectAllPointsUsingPrim implements MinCostToConnectAllPoints {

        private static class Point {
            // index of point in points[]
            final int idx;
            // distance to this point from another point
            final int distance;

            Point(int idx, int distance) {
                this.idx = idx;
                this.distance = distance;
            }
        }

        @Override
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;

            // Form a graph by connecting all possible pair of points
            List<Point>[] graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    graph[i].add(new Point(j, distance));
                    graph[j].add(new Point(i, distance));
                }
            }

            // Prim's algorithm for computing the minimum spanning tree
            int cost = 0;
            int numConnectedPoints = 0;
            boolean[] visited = new boolean[n];
            PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(point -> point.distance)); // min heap
            pq.offer(new Point(0, 0));
            while (numConnectedPoints < n) {
                Point curr = pq.poll();

                // we are going to be adding duplicates to the min heap, therefore `is visited?` check is needed here
                if (visited[curr.idx]) {
                    continue;
                }

                cost += curr.distance;
                numConnectedPoints++;
                visited[curr.idx] = true;
                for (Point neighbor : graph[curr.idx]) {
                    if (!visited[neighbor.idx]) {
                        pq.offer(neighbor);
                    }
                }
            }
            return cost;
        }
    }
}
