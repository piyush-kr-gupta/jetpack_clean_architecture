package com.example.tweeter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.tweeter.api.TweeterAPI
import com.example.tweeter.ui.screens.CategoryScreen
import com.example.tweeter.ui.theme.TweeterTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint //??
class MainActivity : ComponentActivity() {

    @Inject //??
    lateinit var tweeterAPI: TweeterAPI //?? "lateinit"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch { //??
            val response = tweeterAPI.getCategories()
            Log.d("TAG__1", "onCreate: ${response.body().toString()}")
        }

        enableEdgeToEdge()
        setContent {
            TweeterTheme {
                CategoryScreen()
            }
        }
    }
}