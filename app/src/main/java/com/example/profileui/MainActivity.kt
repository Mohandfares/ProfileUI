package com.example.profileui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.profileui.ui.theme.ProfileUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileUITheme {
                ProfileScreen()
            }
        }
    }
}

@Preview(name = "Light Mode",showSystemUi = true)
@Preview(name = "Dark Mode",uiMode = UI_MODE_NIGHT_YES,showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProfileUITheme {
        ProfileScreen()
    }
}