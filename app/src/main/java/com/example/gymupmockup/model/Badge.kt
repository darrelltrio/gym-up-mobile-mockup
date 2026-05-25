package com.example.gymupmockup.model

data class Badge(
    val name: String,
    val description: String,
    val rarity: String,
    val isUnlocked: Boolean,
    val isPremium: Boolean
)