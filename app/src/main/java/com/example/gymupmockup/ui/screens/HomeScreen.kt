package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.data.MockData
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.GoldButton
import com.example.gymupmockup.ui.components.GoldProgressBar
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.LockedPremiumCard
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.components.StatCard
import com.example.gymupmockup.ui.theme.GymDarkGold
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun HomeScreen(
    userPlan: UserPlan
) {
    GymUpScreen {
        WelcomeCard(userPlan = userPlan)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(
                title = "Level",
                value = "50",
                subtitle = "Advanced",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                title = "Streak",
                value = "12",
                subtitle = "days",
                modifier = Modifier.weight(1f)
            )
        }

        ReadyToTrainCard()

        if (userPlan == UserPlan.PREMIUM) {
            AdaptiveQuestCoachCard()
        } else {
            LockedPremiumCard(
                title = "Adaptive Quest Coach Locked",
                description = "Upgrade to unlock smart workout focus, muscle balance analysis, and premium adaptive quests."
            )
        }

        SectionTitle(title = "Weekly Leaderboard")

        LeaderboardPreview(
            userPlan = userPlan
        )
    }
}

@Composable
private fun WelcomeCard(
    userPlan: UserPlan
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(1.dp, GymDarkGold)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            GymDarkGold.copy(alpha = 0.45f),
                            GymSurface,
                            GymSurface
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Column {
                Text(
                    text = "Welcome Back, Darrell",
                    color = GymTextMain,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeMiniStat(
                        value = "125,400 kg",
                        label = "Total Volume"
                    )

                    HomeMiniStat(
                        value = "Advanced",
                        label = "Current Rank"
                    )

                    HomeMiniStat(
                        value = if (userPlan == UserPlan.PREMIUM) "Premium" else "Free",
                        label = "Plan"
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeMiniStat(
    value: String,
    label: String
) {
    Column {
        Text(
            text = value,
            color = GymGold,
            fontWeight = FontWeight.Black,
            fontSize = 14.sp
        )

        Text(
            text = label,
            color = GymTextMuted,
            fontSize = 11.sp
        )
    }
}

@Composable
private fun ReadyToTrainCard() {
    GymUpCard {
        Text(
            text = "Ready to Train?",
            color = GymTextMain,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Text(
            text = "Log today’s workout and keep your streak alive.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        GoldButton(text = "Log New Workout")
    }
}

@Composable
private fun AdaptiveQuestCoachCard() {
    PremiumCard {
        Text(
            text = "Adaptive Quest Coach",
            color = GymGold,
            fontWeight = FontWeight.Black,
            fontSize = 18.sp
        )

        Text(
            text = "Your push volume is 18% lower than your pull volume this week.",
            color = GymTextMain,
            fontSize = 14.sp
        )

        Text(
            text = "Recommended focus: Chest + Shoulders",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        GoldProgressBar(progress = 0.72f)

        Text(
            text = "Complete 2 push sessions to earn the Iron Balance badge.",
            color = GymTextMuted,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun LeaderboardPreview(
    userPlan: UserPlan
) {
    GymUpCard {
        MockData.leaderboard.forEach { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (user.isCurrentUser) {
                            GymDarkGold.copy(alpha = 0.25f)
                        } else {
                            GymSurface
                        },
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${user.rank}. ${user.name}",
                    color = if (user.isCurrentUser) GymGold else GymTextMain,
                    fontWeight = if (user.isCurrentUser) FontWeight.Black else FontWeight.Normal,
                    fontSize = 14.sp
                )

                Text(
                    text = user.totalVolume,
                    color = GymTextMuted,
                    fontSize = 13.sp
                )
            }
        }

        if (userPlan == UserPlan.PREMIUM) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Premium insight: You need 23,400 kg more volume to overtake Sarah.",
                color = GymGold,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}