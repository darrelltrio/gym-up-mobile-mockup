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
import com.example.gymupmockup.data.SuperAdminMockData
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
fun RegisterGymOwnerScreen(
    onBackToSuperAdminDashboard: () -> Unit
) {
    val form = SuperAdminMockData.sampleGymOwnerRegistrationForm

    GymUpScreen {
        PremiumCard {
            Text(
                text = "Register Gym Owner",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Super Admin creates a gym owner account and registers a gym branch into the Gym-Up platform.",
                color = GymTextMain,
                fontSize = 14.sp
            )

            Text(
                text = "Mockup only — fields are dummy and not saved to database.",
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }

        SectionTitle(title = "Gym Information")

        GymUpCard {
            MockInputField(label = "Gym Name", value = form.gymName)
            MockInputField(label = "Gym Location", value = form.gymLocation)
        }

        SectionTitle(title = "Owner Identity")

        GymUpCard {
            MockInputField(label = "Owner Name", value = form.ownerName)
            MockInputField(label = "Owner Email", value = form.ownerEmail)
            MockInputField(label = "Owner Phone", value = form.ownerPhone)
        }

        SectionTitle(title = "Platform Access")

        GymUpCard {
            AccessRow(label = "Access Level", value = form.accessLevel)
            AccessRow(label = "Initial Staff Limit", value = form.initialStaffLimit)
            AccessRow(label = "Member Registration", value = "Enabled")
            AccessRow(label = "Gym Dashboard", value = "Enabled")
            AccessRow(label = "Staff Management", value = "Enabled")
            AccessRow(label = "Member App Access", value = "Full Access")
        }

        GoldButton(text = "Create Gym Owner Account")

        GoldButton(
            text = "Back to Super Admin Dashboard",
            onClick = onBackToSuperAdminDashboard
        )
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