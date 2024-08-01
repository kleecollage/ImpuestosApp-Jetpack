package com.example.impuestosapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.impuestosapp.ui.theme.ImpuestosAppTheme
import com.example.impuestosapp.viewModels.CalcularViewModel1
import com.example.impuestosapp.viewModels.CalcularViewModel2
import com.example.impuestosapp.viewModels.CalcularViewModel3
import com.example.impuestosapp.views.HomeView
import com.example.impuestosapp.views.HomeView2
import com.example.impuestosapp.views.HomeView3

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalcularViewModel3 by viewModels()
        enableEdgeToEdge()
        setContent {
            ImpuestosAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeView3(viewModel)
                }
            }
        }
    }
}