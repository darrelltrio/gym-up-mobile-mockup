package com.example.gymupmockup.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymupmockup.data.SuperAdminMockData
import com.example.gymupmockup.model.GymPartner
import com.example.gymupmockup.ui.components.GoldButton
import com.example.gymupmockup.ui.components.GymUpCard
import com.example.gymupmockup.ui.components.GymUpScreen
import com.example.gymupmockup.ui.components.PremiumCard
import com.example.gymupmockup.ui.components.SectionTitle
import com.example.gymupmockup.ui.components.StatCard
import com.example.gymupmockup.ui.theme.GymDarkGold
import com.example.gymupmockup.ui.theme.GymGold
import com.example.gymupmockup.ui.theme.GymSurface
import com.example.gymupmockup.ui.theme.GymSurfaceSoft
import com.example.gymupmockup.ui.theme.GymTextMain
import com.example.gymupmockup.ui.theme.GymTextMuted

@Composable
fun SuperAdminDashboardScreen() {
    val stats = SuperAdminMockData.platformStats

    GymUpScreen {
        SuperAdminHeroCard()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(
                title = "Gyms",
                value = stats.totalGyms.toString(),
                subtitle = "partners",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                title = "Members",
                value = stats.totalMembers.toString(),
                subtitle = "active",
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(
                title = "Owners",
                value = stats.totalOwners.toString(),
                subtitle = "accounts",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                title = "Retention",
                value = stats.averageRetention,
                subtitle = "average",
                modifier = Modifier.weight(1f)
            )
        }

        SuperAdminActionCard()

        SectionTitle(title = "Recent Platform Activity")

        RecentActivityCard()
    }
}

@Composable
fun SuperAdminGymPartnersScreen() {
    GymUpScreen {
        PremiumCard {
            Text(
                text = "Gym Partners",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "View registered gym partners, owner accounts, retention, and branch status.",
                color = GymTextMain,
                fontSize = 14.sp
            )
        }

        SectionTitle(title = "Registered Gyms")

        SuperAdminMockData.gymPartners.forEach { gym ->
            GymPartnerCard(gym = gym)
        }
    }
}

@Composable
private fun SuperAdminHeroCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(1.dp, GymDarkGold)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            GymDarkGold.copy(alpha = 0.45f),
                            GymSurface,
                            GymSurface
                        )
                    )
                )
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Super Admin Dashboard",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = "Manage gym partners, owner accounts, platform activity, and cross-gym performance.",
                color = GymTextMain,
                fontSize = 14.sp
            )

            Text(
                text = "System scope: multi-gym management",
                color = GymTextMuted,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun SuperAdminActionCard() {
    PremiumCard {
        Text(
            text = "Platform Controls",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Super Admin can create gym owner accounts, review gym performance, and monitor member adoption across all registered gyms.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldButton(text = "+ Register Gym Owner")
    }
}

@Composable
private fun GymPartnerCard(
    gym: GymPartner
) {
    val statusColor = if (gym.status == "Active") GymGold else GymTextMuted

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (gym.status == "Active") GymSurfaceSoft else GymDarkGold
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = gym.name,
                        color = GymTextMain,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Black
                    )

                    Text(
                        text = gym.location,
                        color = GymTextMuted,
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = gym.status,
                    color = statusColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(
                            color = GymSurfaceSoft,
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }

            GymPartnerInfoRow(
                label = "Owner",
                value = gym.ownerName
            )

            GymPartnerInfoRow(
                label = "Active Members",
                value = gym.activeMembers.toString()
            )

            GymPartnerInfoRow(
                label = "Staff Accounts",
                value = gym.staffCount.toString()
            )

            GymPartnerInfoRow(
                label = "Monthly Retention",
                value = gym.monthlyRetention
            )
        }
    }
}

@Composable
private fun GymPartnerInfoRow(
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
            color = GymTextMain,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun RecentActivityCard() {
    GymUpCard {
        SuperAdminMockData.recentActivities.forEach { activity ->
            Text(
                text = "• $activity",
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }
    }
}