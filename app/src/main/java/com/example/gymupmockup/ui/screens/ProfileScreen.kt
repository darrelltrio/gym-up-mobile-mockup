package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.GoldButton
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.LockedPremiumCard
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.ProgressStatRow
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.theme.GymBlack
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun ProfileScreen(
    userPlan: UserPlan
) {
    GymUpScreen {
        ProfileHeaderCard(userPlan = userPlan)

        SectionTitle(title = "Body Stats")

        BodyStatsCard()

        SectionTitle(title = "Current Goal")

        GoalCard()

        SectionTitle(title = "Nutrition Guide")

        NutritionCard(userPlan = userPlan)

        SectionTitle(title = "Membership")

        MembershipCard(userPlan = userPlan)
    }
}

@Composable
private fun ProfileHeaderCard(
    userPlan: UserPlan
) {
    GymUpCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(GymGold),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "D",
                    color = GymBlack,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = "Darrell",
                    color = GymTextMain,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = "Rank: Advanced • Level 50",
                    color = GymGold,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = if (userPlan == UserPlan.PREMIUM) {
                        "Gym Member Access"
                    } else {
                        "Free Member"
                    },
                    color = GymTextMuted,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
private fun BodyStatsCard() {
    GymUpCard {
        ProfileInfoRow(label = "Age", value = "18")
        ProfileInfoRow(label = "Height", value = "175 cm")
        ProfileInfoRow(label = "Weight", value = "65 kg")
        ProfileInfoRow(label = "Activity", value = "Gym 4-5x weekly")
        ProfileInfoRow(label = "Body Goal", value = "Lean Bulk")

        Spacer(modifier = Modifier.height(8.dp))

        GoldButton(text = "Save & Recalculate")
    }
}

@Composable
private fun GoalCard() {
    GymUpCard {
        Text(
            text = "Lean Bulking Phase",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Goal: gain muscle while keeping body fat controlled.",
            color = GymTextMain,
            fontSize = 14.sp
        )

        Text(
            text = "Mock recommendation based on height, weight, activity, and goal.",
            color = GymTextMuted,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun NutritionCard(
    userPlan: UserPlan
) {
    if (userPlan == UserPlan.PREMIUM) {
        MemberNutritionCard()
    } else {
        FreeNutritionCard()
    }
}

@Composable
private fun FreeNutritionCard() {
    GymUpCard {
        Text(
            text = "Basic Calorie Target",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "2,600 kcal/day",
            color = GymTextMain,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Free users get a simple daily calorie target to support consistency.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        LockedPremiumCard(
            title = "Macro Targets Locked",
            description = "Premium unlocks protein, carbs, fat targets, meal ideas, and nutrition phase explanation."
        )
    }
}

@Composable
private fun MemberNutritionCard() {
    PremiumCard {
        Text(
            text = "Member Nutrition Plan",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "2,816 kcal/day",
            color = GymTextMain,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Lean bulk target with controlled surplus.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        ProgressStatRow(
            label = "Protein",
            value = "160g",
            progress = 0.86f
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProgressStatRow(
            label = "Carbs",
            value = "360g",
            progress = 0.78f
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProgressStatRow(
            label = "Fat",
            value = "78g",
            progress = 0.64f
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Meal ideas:",
            color = GymGold,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Chicken rice bowl • Tuna sandwich • Banana oats shake • Eggs and tofu meal",
            color = GymTextMuted,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun MembershipCard(
    userPlan: UserPlan
) {
    if (userPlan == UserPlan.PREMIUM) {
        PremiumCard {
            Text(
                text = "Full Gym Access Active",
                color = GymGold,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Included: Adaptive quests, smart set hints, muscle balance, progress insights, and macro nutrition.",
                color = GymTextMain,
                fontSize = 14.sp
            )

            Text(
                text = "This member account receives full Gym-Up access from the registered gym.",
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }
    } else {
        GymUpCard {
            Text(
                text = "Free Plan",
                color = GymTextMain,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "You can log workouts, view history, complete daily quests, and track basic nutrition.",
                color = GymTextMuted,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            GoldButton(text = "Upgrade Preview")
        }
    }
}

@Composable
private fun ProfileInfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = GymSurfaceSoft,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
            )
            .height(42.dp)
            .then(Modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "   $label",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Text(
            text = "$value   ",
            color = GymTextMain,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}