package com.example.gymupmockup.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gymupmockup.model.AppRole
import com.example.gymupmockup.ui.theme.GymBlack
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun RoleSelector(
    selectedRole: AppRole,
    onRoleSelected: (AppRole) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppRole.entries.forEach { role ->
            val isSelected = selectedRole == role

            Button(
                onClick = { onRoleSelected(role) },
                shape = RoundedCornerShape(100.dp),
                border = BorderStroke(1.dp, GymGold),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) GymGold else GymSurface,
                    contentColor = if (isSelected) GymBlack else GymTextMuted
                )
            ) {
                Text(
                    text = role.label,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}