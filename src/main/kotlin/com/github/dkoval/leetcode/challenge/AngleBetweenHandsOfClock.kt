package com.github.dkoval.leetcode.challenge

import kotlin.math.abs

/**
 * [Angle Between Hands of a Clock](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/)
 *
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 */
object AngleBetweenHandsOfClock {

    fun angleClock(hour: Int, minutes: Int): Double {
        val h = (hour % 12 + minutes.toDouble() / 60) * 30 // 360 deg / 12 h = 30 deg/h
        val m = minutes * 6 // 360 deg / 60 m = 6 deg/m
        val angle = abs(h - m)
        return if (angle > 180) 360 - angle else angle
    }
}