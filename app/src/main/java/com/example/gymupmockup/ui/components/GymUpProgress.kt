package com.example.gymupmockup.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun GoldProgressBar(
    progress: Float,
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        progress = { progress },
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(100.dp)),
        color = GymGold,
        trackColor = GymSurfaceSoft
    )
}

@Composable
fun ProgressStatRow(
    label: String,
    value: String,
    progress: Float,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                color = GymTextMain,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = value,
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        GoldProgressBar(progress = progress)
    }
}