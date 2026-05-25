package com.example.gymupmockup.model

data class LeaderboardUser(
    val rank: Int,
    val name: String,
    val totalVolume: String,
    val isCurrentUser: Boolean = false
)