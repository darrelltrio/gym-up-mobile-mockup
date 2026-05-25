package com.example.gymupmockup.data

import com.example.gymupmockup.model.Badge
import com.example.gymupmockup.model.LeaderboardUser
import com.example.gymupmockup.model.Quest
import com.example.gymupmockup.model.WorkoutHistory

object MockData {

    val freeQuests = listOf(
        Quest(
            title = "Daily Grinder",
            description = "Log one workout today.",
            xpReward = 100,
            badgeReward = "Consistency Spark",
            isPremium = false
        ),
        Quest(
            title = "Protein Discipline",
            description = "Reach your basic nutrition target today.",
            xpReward = 80,
            badgeReward = "Fuel Badge",
            isPremium = false
        )
    )

    val premiumQuests = listOf(
        Quest(
            title = "Adaptive Push Balance",
            description = "Your push volume is lower than your pull volume. Complete 2 chest or shoulder workouts this week.",
            xpReward = 300,
            badgeReward = "Iron Balance Badge",
            isPremium = true
        ),
        Quest(
            title = "Plateau Breaker",
            description = "Beat last week’s total training volume by 5%.",
            xpReward = 450,
            badgeReward = "Golden Progress Badge",
            isPremium = true
        )
    )

    val badges = listOf(
        Badge(
            name = "First Lift",
            description = "Logged your first workout.",
            rarity = "Common",
            isUnlocked = true,
            isPremium = false
        ),
        Badge(
            name = "Streak Spark",
            description = "Maintained a 7-day streak.",
            rarity = "Rare",
            isUnlocked = true,
            isPremium = false
        ),
        Badge(
            name = "Iron Balance",
            description = "Completed an adaptive balance quest.",
            rarity = "Epic",
            isUnlocked = false,
            isPremium = true
        ),
        Badge(
            name = "Golden Progress",
            description = "Beat last week’s volume target.",
            rarity = "Legendary",
            isUnlocked = false,
            isPremium = true
        )
    )

    val workoutHistory = listOf(
        WorkoutHistory(
            date = "October 9, 2025",
            workoutName = "Chest Day",
            duration = "01:13:30",
            totalVolume = "18,400 kg"
        ),
        WorkoutHistory(
            date = "October 8, 2025",
            workoutName = "Leg Day",
            duration = "00:48:10",
            totalVolume = "21,200 kg"
        ),
        WorkoutHistory(
            date = "October 6, 2025",
            workoutName = "Back Day",
            duration = "01:02:44",
            totalVolume = "19,000 kg"
        ),
        WorkoutHistory(
            date = "October 4, 2025",
            workoutName = "Shoulders",
            duration = "00:44:12",
            totalVolume = "9,800 kg"
        )
    )

    val leaderboard = listOf(
        LeaderboardUser(
            rank = 1,
            name = "Alex",
            totalVolume = "152,300 kg"
        ),
        LeaderboardUser(
            rank = 2,
            name = "Sarah",
            totalVolume = "148,800 kg"
        ),
        LeaderboardUser(
            rank = 3,
            name = "Darrell",
            totalVolume = "125,400 kg",
            isCurrentUser = true
        ),
        LeaderboardUser(
            rank = 4,
            name = "Mike",
            totalVolume = "110,100 kg"
        ),
        LeaderboardUser(
            rank = 5,
            name = "Jenny",
            totalVolume = "89,000 kg"
        )
    )
}