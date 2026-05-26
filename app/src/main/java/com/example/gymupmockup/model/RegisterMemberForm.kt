package com.example.gymupmockup.model

data class RegisterMemberForm(
    val fullName: String,
    val email: String,
    val phone: String,
    val goal: String,
    val membershipType: String,
    val startDate: String
)