package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.theme.GymDarkGold
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun LogWorkoutScreen(userPlan: UserPlan) {
    PlaceholderScreen(
        title = "Log Workout",
        description = "Workout timer, selected exercises, set logging, and premium smart set hints.",
        userPlan = userPlan
    )
}

@Composable
fun QuestScreen(userPlan: UserPlan) {
    PlaceholderScreen(
        title = "Quests",
        description = "Daily quests for free users and adaptive quests for premium users.",
        userPlan = userPlan
    )
}

@Composable
fun ProgressScreen(userPlan: UserPlan) {
    PlaceholderScreen(
        title = "Progress",
        description = "Recent history for free users, full history and muscle balance for premium users.",
        userPlan = userPlan
    )
}

@Composable
fun ProfileScreen(userPlan: UserPlan) {
    PlaceholderScreen(
        title = "Profile",
        description = "Body stats, badges, nutrition guide, and freemium membership state.",
        userPlan = userPlan
    )
}

@Composable
private fun PlaceholderScreen(
    title: String,
    description: String,
    userPlan: UserPlan
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.gymupmockup.ui.theme.GymBlack)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            color = GymTextMain,
            fontSize = 26.sp,
            fontWeight = FontWeight.Black
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = GymSurface
            ),
            border = BorderStroke(1.dp, GymDarkGold)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = if (userPlan == UserPlan.PREMIUM) "Premium Mode" else "Free Mode",
                    color = GymGold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = description,
                    color = GymTextMuted,
                    fontSize = 14.sp
                )
            }
        }
    }
}