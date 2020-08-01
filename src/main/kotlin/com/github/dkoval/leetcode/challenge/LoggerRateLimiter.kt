package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * Design a logger system that receives stream of messages along with its timestamps,
 * each message should be printed if and only if it is `not printed in the last 10 seconds`.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message
 * should be printed in the given timestamp, otherwise return false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */

object LoggerRateLimiter {

    interface Logger {
        fun shouldPrintMessage(timestamp: Int, message: String): Boolean
    }

    // Resource: https://baihuqian.github.io/2018-08-10-logger-rate-limiter/
    class SetAndQueueLogger: Logger {
        private val messages = mutableSetOf<String>()
        private val queue: Queue<TimestampedMessage> = LinkedList()

        private data class TimestampedMessage(val timestamp: Int, val message: String)

        override fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
            while (!queue.isEmpty() && timestamp - queue.peek().timestamp >= 10) {
                val oldMessage = queue.remove().message
                messages.remove(oldMessage)
            }
            return if (messages.contains(message)) {
                false
            } else {
                messages.add(message)
                queue.add(TimestampedMessage(timestamp, message))
                true
            }
        }
    }

    // Resource: https://www.youtube.com/watch?v=GXmMeKGSfP4
    class TwoMapsLogger: Logger {
        private val messagesFrom0Till10s = mutableMapOf<String, Int>()
        private val messagesFrom10Till20s = mutableMapOf<String, Int>()
        private var earliestTimestamp = 0

        override fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
            if (timestamp - earliestTimestamp >= 10) {
                messagesFrom10Till20s.putAll(messagesFrom0Till10s)
                messagesFrom0Till10s.clear()
                earliestTimestamp = timestamp
            }
            if (messagesFrom0Till10s.containsKey(message)) return false
            val prevTimestamp = messagesFrom10Till20s[message]
            if (prevTimestamp != null && timestamp - prevTimestamp < 10) return false
            messagesFrom0Till10s[message] = timestamp
            return true
        }
    }
}
