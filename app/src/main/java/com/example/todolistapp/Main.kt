package com.example.todolistapp
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
//Add one more button yourself exactly like this.
//
//Change the title/description differently.
//
//Send me your updated code
@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "🏠 Home Screen")

        Button(onClick = {
            navController.navigate("add")
        }) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // First dummy task
        Button(onClick = {
            val title = "First Task"
            val desc = "This is the first task description"
            navController.navigate("detail/${Uri.encode(title)}/${Uri.encode(desc)}")
        }) {
            Text("Go to First Task Detail")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Second dummy task
       Button(onClick = {
           val title="Third Task"
           val desc="This is the second task for next milestone"
           navController.navigate("detail/${Uri.encode(title)}/${Uri.encode(desc)}")
       }) {
           Text("3Rd Task")
       }
    }
}


@Composable
fun AddTaskScreen(navController: NavController) {


    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "📝 Add Task Screen")
        var title by rememberSaveable { mutableStateOf("") }
        TextField(
            value = title,
            onValueChange = {title=it},
            label = {Text("Task Title")}
            )
        Spacer(modifier = Modifier
            .fillMaxWidth()
        )
        var desc by rememberSaveable{ mutableStateOf("") }
        TextField(
            value = desc,
            onValueChange = {desc=it},
            label = {Text("Description")}
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
        )
        Button(onClick = {navController.navigate("detail/${Uri.encode(title)}/${Uri.encode(desc)}")}) {
            Text("Save")
        }


    }
}

@Composable
fun DetailScreen(title: String, desc: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "📋 Task Details")
        Text("Title: $title")
        Text("Description: $desc")
    }
}
