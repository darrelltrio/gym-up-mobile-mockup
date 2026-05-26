package com.example.gymupmockup.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.model.OwnerStaffTab
import com.example.gymupmockup.model.SuperAdminTab
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun SuperAdminBottomNav(
    selectedTab: SuperAdminTab,
    onTabSelected: (SuperAdminTab) -> Unit
) {
    NavigationBar(
        containerColor = GymSurface
    ) {
        SuperAdminTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                icon = {
                    Text(
                        text = tab.icon,
                        fontSize = 18.sp
                    )
                },
                label = {
                    Text(
                        text = tab.label,
                        fontSize = 11.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = GymGold,
                    selectedTextColor = GymGold,
                    unselectedIconColor = GymTextMuted,
                    unselectedTextColor = GymTextMuted,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun OwnerStaffBottomNav(
    selectedTab: OwnerStaffTab,
    onTabSelected: (OwnerStaffTab) -> Unit
) {
    NavigationBar(
        containerColor = GymSurface
    ) {
        OwnerStaffTab.entries.forEach { tab ->
            NavigationBarItem(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                icon = {
                    Text(
                        text = tab.icon,
                        fontSize = 18.sp
                    )
                },
                label = {
                    Text(
                        text = tab.label,
                        fontSize = 11.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = GymGold,
                    selectedTextColor = GymGold,
                    unselectedIconColor = GymTextMuted,
                    unselectedTextColor = GymTextMuted,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}