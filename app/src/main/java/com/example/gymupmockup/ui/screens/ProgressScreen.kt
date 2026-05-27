package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.data.MockData
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.GoldProgressBar
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.HistoryCard
import com.example.gymupmockup.ui.components.LockedPremiumCard
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.ProgressStatRow
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun ProgressScreen(
    userPlan: UserPlan
) {
    GymUpScreen {
        ProgressHeaderCard(userPlan = userPlan)

        SectionTitle(title = "Volume Progress")

        GymUpCard {
            Text(
                text = "Total Training Volume",
                color = GymTextMuted,
                fontSize = 13.sp
            )

            Text(
                text = "125,400 kg",
                color = GymGold,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            GoldProgressBar(progress = 0.68f)

            Text(
                text = "68% toward next rank",
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }

        if (userPlan == UserPlan.PREMIUM) {
            PremiumProgressInsightCard()
            MuscleBalanceCard()
        } else {
            LockedPremiumCard(
                title = "Progress Insight Locked",
                description = "Member access includes smart progress analysis, muscle balance tracking, and weekly training recommendations."
            )

            LockedPremiumCard(
                title = "Muscle Balance Locked",
                description = "Upgrade to see which muscle groups are undertrained or overtrained based on your workout pattern."
            )
        }

        SectionTitle(title = "Workout History")

        MockData.workoutHistory.forEach { workout ->
            HistoryCard(workout = workout)
        }
    }
}

@Composable
private fun ProgressHeaderCard(
    userPlan: UserPlan
) {
    if (userPlan == UserPlan.PREMIUM) {
        PremiumCard {
            Text(
                text = "Progress Analytics",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Member access analyzes your workout pattern and turns it into actionable training feedback.",
                color = GymTextMain,
                fontSize = 14.sp
            )

            Text(
                text = "Current trend: volume is rising, but push muscles need more attention.",
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }
    } else {
        GymUpCard {
            Text(
                text = "Progress",
                color = GymTextMain,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "View your full workout history and track total training volume.",
                color = GymTextMuted,
                fontSize = 14.sp
            )

            Text(
                text = "Progress insights are included for registered gym members.",
                color = GymGold,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun PremiumProgressInsightCard() {
    PremiumCard {
        Text(
            text = "Smart Progress Insight",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Your total weekly volume increased by 7.8% compared to last week.",
            color = GymTextMain,
            fontSize = 14.sp
        )

        Text(
            text = "Recommendation: maintain volume, but shift one accessory slot toward chest or shoulders.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProgressStatRow(
            label = "Weekly Growth",
            value = "+7.8%",
            progress = 0.78f
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProgressStatRow(
            label = "Consistency Score",
            value = "86%",
            progress = 0.86f
        )
    }
}

@Composable
private fun MuscleBalanceCard() {
    PremiumCard {
        Text(
            text = "Muscle Balance",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Mock analysis based on your recent workout history.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        MuscleBalanceRow(
            muscle = "Chest",
            percentage = "62%",
            progress = 0.62f
        )

        MuscleBalanceRow(
            muscle = "Back",
            percentage = "84%",
            progress = 0.84f
        )

        MuscleBalanceRow(
            muscle = "Legs",
            percentage = "78%",
            progress = 0.78f
        )

        MuscleBalanceRow(
            muscle = "Shoulders",
            percentage = "51%",
            progress = 0.51f
        )

        MuscleBalanceRow(
            muscle = "Arms",
            percentage = "66%",
            progress = 0.66f
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Insight: shoulders are currently the lowest-trained area.",
            color = GymGold,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun MuscleBalanceRow(
    muscle: String,
    percentage: String,
    progress: Float
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = muscle,
            color = GymTextMain,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = percentage,
            color = GymTextMuted,
            fontSize = 13.sp
        )
    }

    Spacer(modifier = Modifier.height(6.dp))

    GoldProgressBar(progress = progress)

    Spacer(modifier = Modifier.height(10.dp))
}