package com.github.dkoval.leetcode.challenge

/**
 * [Robot Bounded In Circle](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/)
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
 *
 * - "G": go straight 1 unit;
 * - "L": turn 90 degrees to the left;
 * - "R": turn 90 degrees to the right.
 *
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */
object RobotBoundedInCircle {

    private enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }

    private fun Direction.turnLeft90Degrees(): Direction = when (this) {
        Direction.NORTH -> Direction.WEST
        Direction.SOUTH -> Direction.EAST
        Direction.WEST -> Direction.SOUTH
        Direction.EAST -> Direction.NORTH
    }

    private fun Direction.turnRight90Degrees(): Direction = when (this) {
        Direction.NORTH -> Direction.EAST
        Direction.SOUTH -> Direction.WEST
        Direction.WEST -> Direction.NORTH
        Direction.EAST -> Direction.SOUTH
    }

    fun isRobotBounded(instructions: String): Boolean {
        // Robot is bounded if
        // - after the set of operations, the robot is still at the position (0, 0).
        // - the robot doesn't point North after the set of operations. It will return to the point (0, 0)
        // after 4 sets of instructions, pointing North, and repeat.
        var x = 0
        var y = 0
        var direction = Direction.NORTH
        for (instruction in instructions) {
            when (instruction) {
                'G' -> {
                    when (direction) {
                        Direction.NORTH -> y++
                        Direction.SOUTH -> y--
                        Direction.WEST -> x--
                        Direction.EAST -> x++
                    }
                }
                'L' -> direction = direction.turnLeft90Degrees()
                'R' -> direction = direction.turnRight90Degrees()
                else -> throw IllegalStateException("Unsupported instruction: $instruction")
            }
        }
        return (x == 0 && y == 0) || direction != Direction.NORTH
    }
}