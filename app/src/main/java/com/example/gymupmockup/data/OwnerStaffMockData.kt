package com.example.gymupmockup.data

import com.example.gymupmockup.model.GymMember
import com.example.gymupmockup.model.LeaderboardUser
import com.example.gymupmockup.model.OwnerGymStats
import com.example.gymupmockup.model.StaffMember
import com.example.gymupmockup.model.RegisterMemberForm

object OwnerStaffMockData {

    val sampleRegistrationForm = RegisterMemberForm(
        fullName = "Gabriela Zahrafani",
        email = "gabriela@example.com",
        phone = "+62 812-3456-7890",
        goal = "Fat Loss",
        membershipType = "Monthly Gym Member",
        startDate = "Today"
    )

    val gymStats = OwnerGymStats(
        gymName = "Iron Temple Gym",
        location = "Gading Serpong",
        activeMembers = 248,
        newMembersThisMonth = 32,
        staffCount = 6,
        retentionRate = "86%"
    )

    val members = listOf(
        GymMember(
            name = "Darrell",
            membershipId = "ITG-0001",
            goal = "Lean Bulk",
            status = "Active",
            level = 50,
            streakDays = 12,
            lastWorkout = "Today"
        ),
        GymMember(
            name = "Brandon",
            membershipId = "ITG-0002",
            goal = "Strength",
            status = "Active",
            level = 38,
            streakDays = 7,
            lastWorkout = "Yesterday"
        ),
        GymMember(
            name = "Rusdi",
            membershipId = "ITG-0003",
            goal = "Fat Loss",
            status = "Active",
            level = 29,
            streakDays = 5,
            lastWorkout = "2 days ago"
        ),
        GymMember(
            name = "Marco",
            membershipId = "ITG-0004",
            goal = "Muscle Gain",
            status = "Needs Follow-up",
            level = 21,
            streakDays = 0,
            lastWorkout = "9 days ago"
        )
    )

    val staff = listOf(
        StaffMember(
            name = "Michael Tan",
            role = "Owner",
            status = "Active"
        ),
        StaffMember(
            name = "Raka Pratama",
            role = "Front Desk Staff",
            status = "Active"
        ),
        StaffMember(
            name = "Sinta Wijaya",
            role = "Personal Trainer",
            status = "Active"
        ),
        StaffMember(
            name = "Kevin Lim",
            role = "Membership Admin",
            status = "Active"
        )
    )

    val gymLeaderboard = listOf(
        LeaderboardUser(
            rank = 1,
            name = "Sarah",
            totalVolume = "148,800 kg"
        ),
        LeaderboardUser(
            rank = 2,
            name = "Darrell",
            totalVolume = "125,400 kg",
            isCurrentUser = true
        ),
        LeaderboardUser(
            rank = 3,
            name = "Brandon",
            totalVolume = "116,200 kg"
        ),
        LeaderboardUser(
            rank = 4,
            name = "Marco",
            totalVolume = "97,500 kg"
        )
    )

    val recentActivities = listOf(
        "Darrell completed Push Day and earned 300 XP.",
        "Marco has not logged a workout for 9 days.",
        "Rusdi updated body goal to Fat Loss.",
        "Brandon unlocked Streak Spark badge.",
        "New member registered: Gabriela."
    )
}