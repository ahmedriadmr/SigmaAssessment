package com.example.sigmaassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.sigmaassessment.core.NavigationRoot
import com.example.sigmaassessment.ui.component.BottomNavigation
import com.example.sigmaassessment.ui.theme.SigmaAssessmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SigmaAssessmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = { BottomNavigation() }) { innerPadding ->
                    val navController = rememberNavController()
                    NavigationRoot(
                        navController = navController, innerPadding = innerPadding.calculateBottomPadding()
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SigmaAssessmentTheme {}
}