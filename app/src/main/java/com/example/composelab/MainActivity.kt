package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.ui.theme.ComposeLabTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.zIndex



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // RegisterScreen(Modifier.padding(innerPadding))
                BoxDemo(Modifier.padding(innerPadding))
                    //StudentList(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Text(
            "Create Account",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
            Button(onClick = { }, modifier = Modifier.weight(1f)) { Text("Cancel") }
            Button(onClick = { }, modifier = Modifier.weight(1f)) { Text("Submit") }
        }
    }
}

data class Student(val name: String, val score: Int)

@Composable
fun StudentList(modifier: Modifier = Modifier) {
    var grid by rememberSaveable { mutableStateOf(false) }
    val students = remember { List(50) { Student("Student ${it + 1}", 50 + it) } }

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { grid = !grid }, modifier = Modifier.fillMaxWidth()) {
            Text(if (grid) "Switch to List" else "Switch to Grid")
        }
        if (grid) {
            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.weight(1f)) {
                items(students) { StudentCard(it) }
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(students) { StudentCard(it) }
            }
        }
    }
}

@Composable
fun StudentCard(student: Student) {
    Column(
        Modifier.fillMaxWidth().padding(4.dp)
            .background(Color(0xFFEEEEEE)).padding(12.dp)
    ) {
        Text(student.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text("Marks: ${student.score}")
    }

    @Composable
    fun BoxDemo(modifier: Modifier = Modifier) {
        Box(modifier = modifier.fillMaxSize().padding(16.dp)) {
            // 1 (bottom): blue
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xFF1565C0))
                    .zIndex(0f)
            )
            // 2 (middle): orange
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 70.dp)
                    .size(160.dp)
                    .background(Color(0xFFEF6C00))
                    .zIndex(1f)
            )
            // 3 (top): red
            Box(
                Modifier
                    .align(Alignment.TopEnd)
                    .size(80.dp)
                    .background(Color(0xFFC62828))
                    .zIndex(2f)
            )
        }
    }
}

@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().padding(16.dp)) {
        // 1 (bottom): blue
        Box(
            Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color(0xFF1565C0))
                .zIndex(0f)
        )
        // 2 (middle): orange
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = 70.dp)
                .size(160.dp)
                .background(Color(0xFFEF6C00))
                .zIndex(1f)
        )
        // 3 (top): red
        Box(
            Modifier
                .align(Alignment.TopEnd)
                .size(80.dp)
                .background(Color(0xFFC62828))
                .zIndex(2f)
        )
    }
}