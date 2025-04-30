package com.example.todolistapp
import android.content.ClipDescription
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

//Add one more button yourself exactly like this.
//
//Change the title/description differently.
//
//Send me your updated code
@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "🏠 Home Screen")

        Button(onClick = { navController.navigate("add") }) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            navController.navigate(
                "detail/${Uri.encode("Test Task")}/${Uri.encode("This is a sample task")}"
            )
        }) {
            Text("View Sample Task")
        }
    }
}


@Composable
fun AddTaskScreen(navController: NavController) {
    var title by rememberSaveable { mutableStateOf("") }
    var desc by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = desc, onValueChange = { desc = it }, label = { Text("Description") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("detail/${Uri.encode(title)}/${Uri.encode(desc)}")
        }) {
            Text("Save and View")
        }
    }
}





@Composable
fun DetailScreen(navController: NavController, title: String?, description: String?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "📋 Task Detail", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Title: ${title ?: "N/A"}")
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Description: ${description ?: "N/A"}")
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("home") }) {
            Text("Go Back")
        }
    }
}
//



