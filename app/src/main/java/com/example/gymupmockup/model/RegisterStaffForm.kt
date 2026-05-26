package com.example.gymupmockup.model

data class RegisterStaffForm(
    val fullName: String,
    val email: String,
    val phone: String,
    val role: String,
    val accessLevel: String,
    val assignedBranch: String
)