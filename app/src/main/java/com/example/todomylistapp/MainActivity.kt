package com.example.todomylistapp

import android.os.Bundle
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
import com.example.todomylistapp.ui.theme.ToDoMyListAppTheme


import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val tasks = remember { mutableStateListOf<Task>() }

            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(navController, tasks)
                }
                composable("add") {
                    AddTaskScreen(navController) { title, desc ->
                        tasks.add(Task(title, desc))
                        navController.popBackStack() // go back to home
                    }
                }
                composable(
                    "detail/{title}/{desc}",
                    arguments = listOf(
                        navArgument("title") { type = NavType.StringType },
                        navArgument("desc") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val title = backStackEntry.arguments?.getString("title")
                    val desc = backStackEntry.arguments?.getString("desc")
                    DetailScreen(navController, title, desc)
                }
            }
        }
    }
}