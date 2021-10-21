package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomizedSetTest {

    @Test
    fun `should validate public contract - set 1`() {
        val set = RandomizedSet()
        assertThat(set.insert(1)).isTrue
        assertThat(set.remove(2)).isFalse
        assertThat(set.insert(2)).isTrue
        assertThat(set.getRandom()).isBetween(1, 2)
        assertThat(set.remove(1)).isTrue
        assertThat(set.insert(2)).isFalse
        assertThat(set.getRandom()).isEqualTo(2)
    }

    @Test
    fun `should validate public contract - set 2`() {
        val set = RandomizedSet()
        assertThat(set.remove(0)).isFalse
        assertThat(set.remove(0)).isFalse
        assertThat(set.insert(0)).isTrue
        assertThat(set.getRandom()).isEqualTo(0)
        assertThat(set.remove(0)).isTrue
        assertThat(set.insert(0)).isTrue
    }
}