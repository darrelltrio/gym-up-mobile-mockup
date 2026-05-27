package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.data.MockData
import com.example.gymupmockup.model.Badge
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.BadgeCard
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.LockedPremiumCard
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.QuestCard
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun QuestScreen(
    userPlan: UserPlan
) {
    GymUpScreen {
        QuestHeaderCard(userPlan = userPlan)

        SectionTitle(title = "Daily Quests")

        MockData.freeQuests.forEach { quest ->
            QuestCard(quest = quest)
        }

        SectionTitle(title = "Adaptive Member Quests")

        if (userPlan == UserPlan.PREMIUM) {
            MockData.premiumQuests.forEach { quest ->
                QuestCard(quest = quest)
            }
        } else {
            MockData.premiumQuests.forEach { quest ->
                LockedPremiumCard(
                    title = quest.title,
                    description = "This adaptive quest is included for full gym member access."
                )
            }
        }

        SectionTitle(title = "Badges")

        BadgeSection(userPlan = userPlan)
    }
}

@Composable
private fun QuestHeaderCard(
    userPlan: UserPlan
) {
    if (userPlan == UserPlan.PREMIUM) {
        PremiumCard {
            Text(
                text = "Quest Board",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Member access includes adaptive quests based on your mock workout pattern.",
                color = GymTextMain,
                fontSize = 14.sp
            )

            Text(
                text = "Current focus: Balance push volume and beat last week’s total volume.",
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }
    } else {
        GymUpCard {
            Text(
                text = "Quest Board",
                color = GymTextMain,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Complete daily quests to earn XP and build consistency.",
                color = GymTextMuted,
                fontSize = 14.sp
            )

            Text(
                text = "Adaptive quests are included for registered gym members.",
                color = GymGold,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun BadgeSection(
    userPlan: UserPlan
) {
    val visibleBadges = MockData.badges.map { badge ->
        if (badge.isPremium && userPlan == UserPlan.PREMIUM) {
            badge.copy(isUnlocked = true)
        } else {
            badge
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        visibleBadges.forEach { badge ->
            if (badge.isPremium && userPlan == UserPlan.FREE) {
                LockedBadgePreview(badge = badge)
            } else {
                BadgeCard(badge = badge)
            }
        }
    }
}

@Composable
private fun LockedBadgePreview(
    badge: Badge
) {
    GymUpCard {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "🔒 ${badge.name}",
                color = GymTextMuted,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = badge.rarity,
                color = GymGold,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Member badge locked. Complete adaptive quests to unlock this badge.",
            color = GymTextMuted,
            fontSize = 13.sp
        )
    }
}