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
import com.example.gymupmockup.model.OwnerStaffTab
import com.example.gymupmockup.model.SuperAdminTab
import com.example.gymupmockup.model.UserPlan
import com.example.gymupmockup.ui.components.RoleSelector
import com.example.gymupmockup.ui.navigation.BottomNav
import com.example.gymupmockup.ui.navigation.OwnerStaffBottomNav
import com.example.gymupmockup.ui.navigation.SuperAdminBottomNav
import com.example.gymupmockup.ui.screens.HomeScreen
import com.example.gymupmockup.ui.screens.LogWorkoutScreen
import com.example.gymupmockup.ui.screens.OwnerStaffAccountsScreen
import com.example.gymupmockup.ui.screens.OwnerStaffDashboardScreen
import com.example.gymupmockup.ui.screens.OwnerStaffMembersScreen
import com.example.gymupmockup.ui.screens.ProfileScreen
import com.example.gymupmockup.ui.screens.ProgressScreen
import com.example.gymupmockup.ui.screens.QuestScreen
import com.example.gymupmockup.ui.screens.SuperAdminDashboardScreen
import com.example.gymupmockup.ui.screens.SuperAdminGymPartnersScreen
import com.example.gymupmockup.ui.theme.GymBlack
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun GymUpApp() {
    var selectedRole by remember { mutableStateOf(AppRole.MEMBER) }

    var memberTab by remember { mutableIntStateOf(0) }
    var superAdminTab by remember { mutableStateOf(SuperAdminTab.DASHBOARD) }
    var ownerStaffTab by remember { mutableStateOf(OwnerStaffTab.DASHBOARD) }

    Scaffold(
        containerColor = GymBlack,
        bottomBar = {
            when (selectedRole) {
                AppRole.SUPER_ADMIN -> {
                    SuperAdminBottomNav(
                        selectedTab = superAdminTab,
                        onTabSelected = { superAdminTab = it }
                    )
                }

                AppRole.OWNER_STAFF -> {
                    OwnerStaffBottomNav(
                        selectedTab = ownerStaffTab,
                        onTabSelected = { ownerStaffTab = it }
                    )
                }

                AppRole.MEMBER -> {
                    BottomNav(
                        selectedTab = memberTab,
                        onTabSelected = { memberTab = it }
                    )
                }
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
                    memberTab = 0
                    superAdminTab = SuperAdminTab.DASHBOARD
                    ownerStaffTab = OwnerStaffTab.DASHBOARD
                }
            )

            when (selectedRole) {
                AppRole.SUPER_ADMIN -> {
                    when (superAdminTab) {
                        SuperAdminTab.DASHBOARD -> SuperAdminDashboardScreen()
                        SuperAdminTab.GYM_PARTNERS -> SuperAdminGymPartnersScreen()
                    }
                }

                AppRole.OWNER_STAFF -> {
                    when (ownerStaffTab) {
                        OwnerStaffTab.DASHBOARD -> OwnerStaffDashboardScreen()
                        OwnerStaffTab.MEMBERS -> OwnerStaffMembersScreen()
                        OwnerStaffTab.STAFF -> OwnerStaffAccountsScreen()
                    }
                }

                AppRole.MEMBER -> {
                    MemberContent(selectedTab = memberTab)
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