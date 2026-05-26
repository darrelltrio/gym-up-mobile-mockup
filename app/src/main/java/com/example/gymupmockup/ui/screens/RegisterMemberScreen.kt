package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.data.OwnerStaffMockData
import com.example.gymupmockup.ui.components.GoldButton
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun RegisterMemberScreen() {
    val form = OwnerStaffMockData.sampleRegistrationForm

    GymUpScreen {
        PremiumCard {
            Text(
                text = "Register New Member",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Staff registers a new gym member and activates their full Gym-Up access.",
                color = GymTextMain,
                fontSize = 14.sp
            )

            Text(
                text = "Mockup only — fields are dummy and not saved to database.",
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }

        SectionTitle(title = "Member Identity")

        GymUpCard {
            MockInputField(label = "Full Name", value = form.fullName)
            MockInputField(label = "Email", value = form.email)
            MockInputField(label = "Phone Number", value = form.phone)
        }

        SectionTitle(title = "Membership Setup")

        GymUpCard {
            MockInputField(label = "Fitness Goal", value = form.goal)
            MockInputField(label = "Membership Type", value = form.membershipType)
            MockInputField(label = "Start Date", value = form.startDate)
        }

        SectionTitle(title = "Default Member Access")

        GymUpCard {
            AccessRow("Workout Logging", "Enabled")
            AccessRow("Adaptive Quests", "Enabled")
            AccessRow("Badges & XP", "Enabled")
            AccessRow("Progress Insight", "Enabled")
            AccessRow("Muscle Balance", "Enabled")
            AccessRow("Nutrition Macros", "Enabled")
        }

        GoldButton(text = "Create Member Account")
    }
}

@Composable
private fun MockInputField(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = GymSurfaceSoft,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Text(
            text = label,
            color = GymTextMuted,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = GymTextMain,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun AccessRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = GymSurfaceSoft,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Text(
            text = value,
            color = GymGold,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}