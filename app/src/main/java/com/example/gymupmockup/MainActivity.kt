package com.example.gymupmockup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gymupmockup.ui.GymUpApp
import com.example.gymupmockup.ui.theme.GymUpMockupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymUpMockupTheme {
                GymUpApp()
            }
        }
    }
}