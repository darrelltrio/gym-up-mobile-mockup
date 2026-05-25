package com.example.gymupmockup.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import com.example.gymupmockup.model.Badge
import com.example.gymupmockup.model.Quest
import com.example.gymupmockup.model.WorkoutHistory
import com.example.gymupmockup.ui.theme.GymDarkGold
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun GymUpCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(1.dp, GymSurfaceSoft)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            content = content
        )
    }
}

@Composable
fun PremiumCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(1.dp, GymGold)
    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            GymDarkGold.copy(alpha = 0.45f),
                            GymSurface,
                            GymSurface
                        )
                    )
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            content = content
        )
    }
}

@Composable
fun LockedPremiumCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurfaceSoft
        ),
        border = BorderStroke(1.dp, GymDarkGold.copy(alpha = 0.6f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "🔒 $title",
                color = GymTextMain,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = description,
                color = GymTextMuted,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedGoldButton(text = "Preview Premium")
        }
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    GymUpCard(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = GymTextMuted,
            fontSize = 12.sp
        )

        Text(
            text = value,
            color = GymGold,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = subtitle,
            color = GymTextMuted,
            fontSize = 12.sp
        )
    }
}

@Composable
fun QuestCard(
    quest: Quest,
    modifier: Modifier = Modifier
) {
    val isPremium = quest.isPremium

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (isPremium) GymGold else GymSurfaceSoft
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = if (isPremium) "★ ${quest.title}" else quest.title,
                    color = if (isPremium) GymGold else GymTextMain,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = "+${quest.xpReward} XP",
                    color = GymGold,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = quest.description,
                color = GymTextMuted,
                fontSize = 13.sp
            )

            quest.badgeReward?.let { reward ->
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Reward: $reward",
                    color = GymTextMain,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun BadgeCard(
    badge: Badge,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (badge.isUnlocked) GymSurface else GymSurfaceSoft
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (badge.isPremium) GymGold else GymSurfaceSoft
        )
    ) {
        Column(
            modifier = Modifier.padding(14.dp)
        ) {
            Text(
                text = if (badge.isUnlocked) "★ ${badge.name}" else "🔒 ${badge.name}",
                color = if (badge.isUnlocked) GymTextMain else GymTextMuted,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${badge.rarity} • ${badge.description}",
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun HistoryCard(
    workout: WorkoutHistory,
    modifier: Modifier = Modifier
) {
    GymUpCard(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = workout.workoutName,
                color = GymGold,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = workout.duration,
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }

        Text(
            text = workout.date,
            color = GymTextMuted,
            fontSize = 12.sp
        )

        Text(
            text = "Volume: ${workout.totalVolume}",
            color = GymTextMain,
            fontSize = 13.sp
        )
    }
}