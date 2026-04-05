package com.github.dkoval.leetcode.challenge;

import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/robot-return-to-origin/">Robot Return to Origin</a>
 * <p>
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
 * judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move.
 * Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
 * <p>
 * Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once,
 * 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= moves.length <= 2 * 104</li>
 *  <li>moves only contain the characters 'U', 'D', 'L' and 'R'.</li>
 * </ul>
 */
public interface RobotReturnToOrigin {

    boolean judgeCircle(String moves);

    class RobotReturnToOriginRev1 implements RobotReturnToOrigin {

        private static final Map<Character, Direction> MOVES = Map.of(
                'U', new Direction(-1, 0),
                'D', new Direction(1, 0),
                'L', new Direction(0, -1),
                'R', new Direction(0, 1)
        );

        @Override
        public boolean judgeCircle(String moves) {
            final var n = moves.length();

            var x = 0;
            var y = 0;
            for (var i = 0; i < n; i++) {
                final var d = MOVES.get(moves.charAt(i));
                x += d.dx;
                y += d.dy;
            }
            return (x == 0) && (y == 0);
        }

        private record Direction(int dx, int dy) {
        }
    }
}
