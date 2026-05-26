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
import com.example.gymupmockup.data.OwnerStaffMockData
import com.example.gymupmockup.model.GymMember
import com.example.gymupmockup.model.StaffMember
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
fun OwnerStaffScreen() {
    val stats = OwnerStaffMockData.gymStats

    GymUpScreen {
        OwnerStaffHeroCard()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(
                title = "Members",
                value = stats.activeMembers.toString(),
                subtitle = "active",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                title = "New",
                value = stats.newMembersThisMonth.toString(),
                subtitle = "this month",
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(
                title = "Staff",
                value = stats.staffCount.toString(),
                subtitle = "accounts",
                modifier = Modifier.weight(1f)
            )

            StatCard(
                title = "Retention",
                value = stats.retentionRate,
                subtitle = "monthly",
                modifier = Modifier.weight(1f)
            )
        }

        StaffActionCard()

        SectionTitle(title = "Member Management")

        OwnerStaffMockData.members.forEach { member ->
            MemberManagementCard(member = member)
        }

        SectionTitle(title = "Gym Leaderboard")

        GymLeaderboardCard()

        SectionTitle(title = "Staff Accounts")

        OwnerStaffMockData.staff.forEach { staff ->
            StaffAccountCard(staff = staff)
        }

        SectionTitle(title = "Recent Member Activity")

        RecentMemberActivityCard()
    }
}

@Composable
private fun OwnerStaffHeroCard() {
    val stats = OwnerStaffMockData.gymStats

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
                text = "Owner / Staff Dashboard",
                color = GymGold,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black
            )

            Text(
                text = stats.gymName,
                color = GymTextMain,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${stats.location} • Member registration and gym activity monitoring",
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
private fun StaffActionCard() {
    PremiumCard {
        Text(
            text = "Staff Controls",
            color = GymGold,
            fontSize = 18.sp,
            fontWeight = FontWeight.Black
        )

        Text(
            text = "Register new gym members, review member status, and monitor activity from one staff dashboard.",
            color = GymTextMuted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldButton(text = "+ Register New Member")
    }
}

@Composable
private fun MemberManagementCard(
    member: GymMember
) {
    val statusColor = if (member.status == "Active") GymGold else GymTextMuted

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = GymSurface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (member.status == "Active") GymSurfaceSoft else GymDarkGold
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
                        text = member.name,
                        color = GymTextMain,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Black
                    )

                    Text(
                        text = member.membershipId,
                        color = GymTextMuted,
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = member.status,
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

            InfoRow(label = "Goal", value = member.goal)
            InfoRow(label = "Level", value = member.level.toString())
            InfoRow(label = "Streak", value = "${member.streakDays} days")
            InfoRow(label = "Last Workout", value = member.lastWorkout)
        }
    }
}

@Composable
private fun GymLeaderboardCard() {
    GymUpCard {
        OwnerStaffMockData.gymLeaderboard.forEach { user ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (user.isCurrentUser) {
                            GymDarkGold.copy(alpha = 0.25f)
                        } else {
                            GymSurface
                        },
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${user.rank}. ${user.name}",
                    color = if (user.isCurrentUser) GymGold else GymTextMain,
                    fontWeight = if (user.isCurrentUser) FontWeight.Black else FontWeight.Normal,
                    fontSize = 14.sp
                )

                Text(
                    text = user.totalVolume,
                    color = GymTextMuted,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
private fun StaffAccountCard(
    staff: StaffMember
) {
    GymUpCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = staff.name,
                    color = GymTextMain,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = staff.role,
                    color = GymTextMuted,
                    fontSize = 13.sp
                )
            }

            Text(
                text = staff.status,
                color = GymGold,
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
    }
}

@Composable
private fun RecentMemberActivityCard() {
    GymUpCard {
        OwnerStaffMockData.recentActivities.forEach { activity ->
            Text(
                text = "• $activity",
                color = GymTextMuted,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
private fun InfoRow(
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