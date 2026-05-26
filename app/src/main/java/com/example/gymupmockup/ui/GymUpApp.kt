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
import com.example.gymupmockup.model.AppRole
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.RoleSelector
import com.example.gymupmockup.ui.navigation.BottomNav
import com.example.gymupmockup.ui.screens.HomeScreen
import com.example.gymupmockup.ui.screens.LogWorkoutScreen
import com.example.gymupmockup.ui.screens.ProfileScreen
import com.example.gymupmockup.ui.screens.ProgressScreen
import com.example.gymupmockup.ui.screens.QuestScreen
import com.example.gymupmockup.ui.screens.SuperAdminScreen
import com.example.gymupmockup.ui.screens.OwnerStaffScreen
import com.example.gymupmockup.ui.theme.GymBlack
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun GymUpApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var selectedRole by remember { mutableStateOf(AppRole.MEMBER) }

    Scaffold(
        containerColor = GymBlack,
        bottomBar = {
            if (selectedRole == AppRole.MEMBER) {
                BottomNav(
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GymBlack)
                .padding(innerPadding)
        ) {
            AppTopBar(
                selectedRole = selectedRole,
                onRoleSelected = { role ->
                    selectedRole = role
                    selectedTab = 0
                }
            )

            when (selectedRole) {
                AppRole.SUPER_ADMIN -> {
                    SuperAdminScreen()
                }

                AppRole.OWNER_STAFF -> {
                    OwnerStaffScreen()
                }

                AppRole.MEMBER -> {
                    MemberContent(selectedTab = selectedTab)
                }
            }
        }
    }
}

@Composable
private fun MemberContent(
    selectedTab: Int
) {
    val memberAccess = UserPlan.PREMIUM

    when (selectedTab) {
        0 -> HomeScreen(memberAccess)
        1 -> LogWorkoutScreen(memberAccess)
        2 -> QuestScreen(memberAccess)
        3 -> ProgressScreen(memberAccess)
        4 -> ProfileScreen(memberAccess)
    }
}

@Composable
private fun AppTopBar(
    selectedRole: AppRole,
    onRoleSelected: (AppRole) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(GymBlack)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                    text = "Multi-role gym management mockup",
                    color = GymTextMuted,
                    fontSize = 12.sp
                )
            }

            Text(
                text = selectedRole.label,
                color = GymGold,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }

        RoleSelector(
            selectedRole = selectedRole,
            onRoleSelected = onRoleSelected
        )
    }
}