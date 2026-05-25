package com.example.gymupmockup.model

data class Quest(
    val title: String,
    val description: String,
    val xpReward: Int,
    val badgeReward: String?,
    val isPremium: Boolean
)