package com.example.gymupmockup.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.theme.GymBlack
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun PremiumToggle(
    userPlan: UserPlan,
    onToggle: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (userPlan == UserPlan.PREMIUM) "Premium" else "Free",
            color = if (userPlan == UserPlan.PREMIUM) GymGold else GymTextMuted,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(8.dp))

        Switch(
            checked = userPlan == UserPlan.PREMIUM,
            onCheckedChange = { onToggle() },
            colors = SwitchDefaults.colors(
                checkedThumbColor = GymBlack,
                checkedTrackColor = GymGold,
                uncheckedThumbColor = GymTextMuted,
                uncheckedTrackColor = GymSurfaceSoft
            )
        )
    }
}