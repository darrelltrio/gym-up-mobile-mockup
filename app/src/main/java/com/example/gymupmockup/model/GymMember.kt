package com.example.gymupmockup.model

data class GymMember(
    val name: String,
    val membershipId: String,
    val goal: String,
    val status: String,
    val level: Int,
    val streakDays: Int,
    val lastWorkout: String
)