package com.github.dkoval.leetcode.challenge

/**
 * [Car Pooling](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/)
 *
 * You are driving a vehicle that has capacity empty seats initially available for passengers.
 * The vehicle only drives east (ie. it cannot turn around and drive west.)
 *
 * Given a list of trips, ```trip[i] = [num_passengers, start_location, end_location]``` contains information about
 * the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.
 * The locations are given as the number of kilometers due east from your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 */
interface CarPolling {

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean
}

object CarPollingUsingSortedMap : CarPolling {

    override fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val deltas = sortedMapOf<Int, Int>() // we want keys to be sorted
        for ((numPassengers, startLocation, endLocation) in trips) {
            deltas[startLocation] = deltas.getOrDefault(startLocation, 0) - numPassengers
            deltas[endLocation] = deltas.getOrDefault(endLocation, 0) + numPassengers
        }
        var numEmptySeats = capacity
        for ((_, delta) in deltas) {
            numEmptySeats += delta
            if (numEmptySeats < 0) return false
        }
        return true
    }
}

object CarPollingUsingArray : CarPolling {

    override fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val deltas = IntArray(1001) // array size is taken from the problem's constraints
        for ((numPassengers, startLocation, endLocation) in trips) {
            deltas[startLocation] -= numPassengers
            deltas[endLocation] += numPassengers
        }
        var numEmptySeats = capacity
        for (delta in deltas) {
            numEmptySeats += delta
            if (numEmptySeats < 0) return false
        }
        return true
    }
}