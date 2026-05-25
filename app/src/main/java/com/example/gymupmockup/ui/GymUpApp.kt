package com.example.gymupmockup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.PremiumToggle
import com.example.gymupmockup.ui.navigation.BottomNav
import com.example.gymupmockup.ui.screens.HomeScreen
import com.example.gymupmockup.ui.screens.LogWorkoutScreen
import com.example.gymupmockup.ui.screens.ProfileScreen
import com.example.gymupmockup.ui.screens.ProgressScreen
import com.example.gymupmockup.ui.screens.QuestScreen
import com.example.gymupmockup.ui.theme.GymBlack
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun GymUpApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var userPlan by remember { mutableStateOf(UserPlan.FREE) }

    Scaffold(
        containerColor = GymBlack,
        bottomBar = {
            BottomNav(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GymBlack)
                .padding(innerPadding)
        ) {
            AppTopBar(
                userPlan = userPlan,
                onTogglePlan = {
                    userPlan = if (userPlan == UserPlan.FREE) {
                        UserPlan.PREMIUM
                    } else {
                        UserPlan.FREE
                    }
                }
            )

            when (selectedTab) {
                0 -> HomeScreen(userPlan)
                1 -> LogWorkoutScreen(userPlan)
                2 -> QuestScreen(userPlan)
                3 -> ProgressScreen(userPlan)
                4 -> ProfileScreen(userPlan)
            }
        }
    }
}

@Composable
private fun AppTopBar(
    userPlan: UserPlan,
    onTogglePlan: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(GymBlack)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "GYM-UP",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Freemium mockup demo",
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }

        PremiumToggle(
            userPlan = userPlan,
            onToggle = onTogglePlan
        )
    }
}