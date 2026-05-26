package com.example.gymupmockup.model

data class OwnerGymStats(
    val gymName: String,
    val location: String,
    val activeMembers: Int,
    val newMembersThisMonth: Int,
    val staffCount: Int,
    val retentionRate: String
)