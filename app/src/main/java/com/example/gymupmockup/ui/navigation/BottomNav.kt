package com.example.gymupmockup.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun BottomNav(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf(
        BottomTab("Home", "⌂"),
        BottomTab("Log", "+"),
        BottomTab("Quests", "★"),
        BottomTab("Progress", "↗"),
        BottomTab("Profile", "●")
    )

    NavigationBar(
        containerColor = GymSurface
    ) {
        tabs.forEachIndexed { index, tab ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                icon = {
                    Text(
                        text = tab.icon,
                        fontSize = 18.sp
                    )
                },
                label = {
                    Text(
                        text = tab.title,
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

data class BottomTab(
    val title: String,
    val icon: String
)