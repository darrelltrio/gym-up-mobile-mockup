package com.example.gymupmockup.model

data class RegisterGymOwnerForm(
    val gymName: String,
    val gymLocation: String,
    val ownerName: String,
    val ownerEmail: String,
    val ownerPhone: String,
    val accessLevel: String,
    val initialStaffLimit: String
)