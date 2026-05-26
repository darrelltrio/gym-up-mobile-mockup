package com.example.gymupmockup.model

data class GymPartner(
    val name: String,
    val location: String,
    val ownerName: String,
    val activeMembers: Int,
    val staffCount: Int,
    val status: String,
    val monthlyRetention: String
)