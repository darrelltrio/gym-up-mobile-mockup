package com.example.gymupmockup.model

enum class SuperAdminTab(
    val label: String,
    val icon: String
) {
    DASHBOARD("Dashboard", "⌂"),
    GYM_PARTNERS("Gyms", "◆")
}

enum class OwnerStaffTab(
    val label: String,
    val icon: String
) {
    DASHBOARD("Dashboard", "⌂"),
    MEMBERS("Members", "●"),
    STAFF("Staff", "▣")
}