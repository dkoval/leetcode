package com.github.dkoval.leetcode.challenge;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/process-tasks-using-servers/">Process Tasks Using Servers</a>
 * <p>
 * You are given two 0-indexed integer arrays servers and tasks of lengths n and m respectively.
 * servers[i] is the weight of the i-th server, and tasks[j] is the time needed to process the j-th task in seconds.
 * <p>
 * Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.
 * <p>
 * At second j, the jth task is inserted into the queue (starting with the 0th task being inserted at second 0).
 * As long as there are free servers and the queue is not empty, the task in the front of the queue will be assigned to
 * a free server with the smallest weight, and in case of a tie, it is assigned to a free server with the smallest index.
 * <p>
 * If there are no free servers and the queue is not empty, we wait until a server becomes free and immediately assign the next task.
 * If multiple servers become free at the same time, then multiple tasks from the queue will be assigned in order of insertion
 * following the weight and index priorities above.
 * <p>
 * A server that is assigned task j at second t will be free again at second t + tasks[j].
 * <p>
 * Build an array ans of length m, where ans[j] is the index of the server the j-th task will be assigned to.
 * <p>
 * Return the array ans.
 * <p>
 * Constraints:
 * <ul>
 *  <li>servers.length == n</li>
 *  <li>tasks.length == m</li>
 *  <li>1 <= n, m <= 2 * 10^5</li>
 *  <li>1 <= servers[i], tasks[j] <= 2 * 10^5</li>
 * </ul>
 */
public interface ProcessTasksUsingServers {

    int[] assignTasks(int[] servers, int[] tasks);

    class ProcessTasksUsingServersRev1 implements ProcessTasksUsingServers {

        private record AvailableServerInfo(
                int id,
                int weight
        ) implements Comparable<AvailableServerInfo> {

            @Override
            public int compareTo(AvailableServerInfo that) {
                return (weight == that.weight)
                        ? Integer.compare(id, that.id)
                        : Integer.compare(weight, that.weight);
            }

            BusyServerInfo busyUntil(int availableAt) {
                return new BusyServerInfo(id, weight, availableAt);
            }
        }

        private record BusyServerInfo(
                int id,
                int weight,
                int availableAt
        ) implements Comparable<BusyServerInfo> {

            @Override
            public int compareTo(BusyServerInfo that) {
                return (availableAt == that.availableAt)
                        ? (weight == that.weight)
                        ? Integer.compare(id, that.id)
                        : Integer.compare(weight, that.weight)
                        : Integer.compare(availableAt, that.availableAt);
            }

            AvailableServerInfo availableAgain() {
                return new AvailableServerInfo(id, weight);
            }

            BusyServerInfo takeTask(int duration) {
                return new BusyServerInfo(id, weight, availableAt + duration);
            }
        }

        @Override
        public int[] assignTasks(int[] servers, int[] tasks) {
            final var n = servers.length;
            final var m = tasks.length;

            final var availableServers = new PriorityQueue<AvailableServerInfo>();
            final var busyServers = new PriorityQueue<BusyServerInfo>();

            for (var i = 0; i < n; i++) {
                availableServers.offer(new AvailableServerInfo(i, servers[i]));
            }

            final var res = new int[m];
            for (var j = 0; j < m; j++) {
                while (!busyServers.isEmpty() && busyServers.peek().availableAt <= j) {
                    final var busyServer = busyServers.poll();
                    availableServers.offer(busyServer.availableAgain());
                }

                if (!availableServers.isEmpty()) {
                    final var availableServer = availableServers.poll();
                    res[j] = availableServer.id;
                    busyServers.offer(availableServer.busyUntil(j + tasks[j]));
                } else {
                    final var busyServer = busyServers.poll();
                    res[j] = busyServer.id;
                    busyServers.offer(busyServer.takeTask(tasks[j]));
                }
            }
            return res;
        }
    }
}
