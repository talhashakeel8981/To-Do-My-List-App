package com.example.todolistapp

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar


//data class Task(val title: String, val description: String)



@Composable
fun HomeScreen(navController: NavController, tasks: List<Task>) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") }) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {

            Text("🏠 Home Screen", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(16.dp))

            if (tasks.isEmpty()) {
                Text("No tasks added yet.")
            } else {
                LazyColumn {
                    items(tasks.size) { index ->
                        val task = tasks[index]
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate("detail/${Uri.encode(task.title)}/${Uri.encode(task.description)}")
                                }
                                .padding(8.dp)
                        ) {
                            Text(task.title, style = MaterialTheme.typography.titleMedium)
                            Text(task.description, style = MaterialTheme.typography.bodySmall)
                        }
                        Divider()
                    }
                }
            }
        }
    }
}






@Composable
fun AddTaskScreen(navController: NavController, onSave: (String, String) -> Unit) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Text(text = "➕ Add Task", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = desc,
            onValueChange = { desc = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (title.isNotBlank() && desc.isNotBlank()) {
                    onSave(title, desc)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Task")
        }
    }
}




@Composable
fun DetailScreen(navController: NavController, title: String?, description: String?) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Text(text = "📋 Task Detail", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Title: ${title ?: "N/A"}")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Description: ${description ?: "N/A"}")
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Go Back")
        }
    }
}


@Composable
fun DividerExample ()
{
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        Text("Hello Talha ")
        Divider(color = Color.Gray,
            thickness = 2.dp,

            )
        Text("Hello Talha ")
    }

}
@Preview(showBackground = true) // ✅ Fix this line
@Composable
fun DividerPreview() {
    DividerExample()
}