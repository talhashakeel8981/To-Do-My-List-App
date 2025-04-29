package com.example.todolistapp

data class Task (
    val title: String,
    val description: String,
    val dueDate: String,
    var isCompleted: Boolean = false
)