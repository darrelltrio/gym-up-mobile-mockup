package com.example.gymupmockup.data

import com.example.gymupmockup.model.GymPartner
import com.example.gymupmockup.model.SuperAdminStats

object SuperAdminMockData {

    val platformStats = SuperAdminStats(
        totalGyms = 8,
        totalMembers = 1248,
        totalOwners = 8,
        averageRetention = "82%"
    )

    val gymPartners = listOf(
        GymPartner(
            name = "Iron Temple Gym",
            location = "Gading Serpong",
            ownerName = "Michael Tan",
            activeMembers = 248,
            staffCount = 6,
            status = "Active",
            monthlyRetention = "86%"
        ),
        GymPartner(
            name = "Atlas Fitness Club",
            location = "BSD City",
            ownerName = "Sarah Wijaya",
            activeMembers = 192,
            staffCount = 4,
            status = "Active",
            monthlyRetention = "81%"
        ),
        GymPartner(
            name = "Titan Strength House",
            location = "Tangerang",
            ownerName = "Kevin Hartono",
            activeMembers = 311,
            staffCount = 7,
            status = "Active",
            monthlyRetention = "88%"
        ),
        GymPartner(
            name = "Pulse Gym",
            location = "Jakarta Barat",
            ownerName = "Nadia Putri",
            activeMembers = 147,
            staffCount = 3,
            status = "Needs Review",
            monthlyRetention = "68%"
        )
    )

    val recentActivities = listOf(
        "Iron Temple Gym registered 12 new members this week.",
        "Pulse Gym retention dropped below 70%. Review recommended.",
        "Atlas Fitness Club added 2 new staff accounts.",
        "Titan Strength House reached 300+ active members.",
        "New owner account created for Gading Serpong branch."
    )
}