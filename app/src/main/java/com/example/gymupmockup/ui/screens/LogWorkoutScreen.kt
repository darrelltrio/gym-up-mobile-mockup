package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.GoldButton
import com.example.gymupmockup.ui.components.GoldProgressBar
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.LockedPremiumCard
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun LogWorkoutScreen(
    userPlan: UserPlan
) {
    GymUpScreen {
        WorkoutHeaderCard()

        SectionTitle(title = "Current Session")

        ExerciseLogCard(
            exerciseName = "Bench Press",
            muscleGroup = "Chest",
            sets = listOf(
                WorkoutSet("Set 1", "30 kg", "8 reps"),
                WorkoutSet("Set 2", "40 kg", "6 reps"),
                WorkoutSet("Set 3", "45 kg", "5 reps")
            )
        )

        ExerciseLogCard(
            exerciseName = "Overhead Press",
            muscleGroup = "Shoulders",
            sets = listOf(
                WorkoutSet("Set 1", "20 kg", "10 reps"),
                WorkoutSet("Set 2", "25 kg", "8 reps")
            )
        )

        ExerciseLogCard(
            exerciseName = "Tricep Pushdown",
            muscleGroup = "Arms",
            sets = listOf(
                WorkoutSet("Set 1", "25 kg", "12 reps"),
                WorkoutSet("Set 2", "30 kg", "10 reps")
            )
        )

        if (userPlan == UserPlan.PREMIUM) {
            SmartSetHintCard()
        } else {
            LockedPremiumCard(
                title = "Smart Set Recommendation Locked",
                description = "Registered Gym Members get fatigue hints, suggested next exercise, and volume-based workout guidance."
            )
        }

        GoldButton(text = "Finish Workout")
    }
}

@Composable
private fun WorkoutHeaderCard() {
    GymUpCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Logging New Workout",
                    color = GymTextMain,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = "Push Day",
                    color = GymTextMuted,
                    fontSize = 13.sp
                )
            }

            Column {
                Text(
                    text = "00:08:32",
                    color = GymGold,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = "Timer",
                    color = GymTextMuted,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        GoldButton(text = "+ Exercise")
    }
}

@Composable
private fun ExerciseLogCard(
    exerciseName: String,
    muscleGroup: String,
    sets: List<WorkoutSet>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(1.dp, GymSurfaceSoft)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = exerciseName,
                        color = GymGold,
                        fontWeight = FontWeight.Black,
                        fontSize = 17.sp
                    )

                    Text(
                        text = muscleGroup,
                        color = GymTextMuted,
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = "${sets.size} sets",
                    color = GymTextMuted,
                    fontSize = 12.sp
                )
            }

            sets.forEach { set ->
                WorkoutSetRow(set = set)
            }

            GoldButton(text = "+ Add Set")
        }
    }
}

@Composable
private fun WorkoutSetRow(
    set: WorkoutSet
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = set.label,
            color = GymTextMain,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = set.weight,
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Text(
            text = set.reps,
            color = GymTextMuted,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun SmartSetHintCard() {
    PremiumCard {
        Text(
            text = "Smart Set Recommendation",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Your pressing volume is getting high for this session.",
            color = GymTextMain,
            fontSize = 14.sp
        )

        Text(
            text = "Suggested next move: lateral raises or light tricep isolation instead of another heavy press.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Session fatigue estimate",
            color = GymTextMuted,
            fontSize = 12.sp
        )

        GoldProgressBar(progress = 0.76f)

        Text(
            text = "76% — keep form clean and avoid ego lifting.",
            color = GymTextMuted,
            fontSize = 12.sp
        )
    }
}

private data class WorkoutSet(
    val label: String,
    val weight: String,
    val reps: String
)