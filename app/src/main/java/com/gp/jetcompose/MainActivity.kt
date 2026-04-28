package com.gp.jetCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Description: Main Activity
 * Author: Gokulpriya
 * Date: 27/04/26
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                MyScreen()
                CounterScreen()
                Greeting(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}

@Composable
fun MyScreen() {
    Text(text = "Hello GP")
}

@Composable
fun CounterScreen() {
    var count by remember { mutableIntStateOf(0) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Count: $count")
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
        Button(onClick = { count = 0 }) {
            Text(text = "Reset")
        }
    }
}

@Composable
fun Greeting(modifier: Modifier) {
    Card(modifier = modifier) {
        var expanded by remember { mutableStateOf(false) }
        Column(
            Modifier
                .clickable { expanded = !expanded }
                .padding(16.dp)
                .fillMaxWidth(0.8f)) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Welcome image",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            AnimatedVisibility(expanded) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Welcome GP!",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 6.dp
                            )
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "How are you!",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(
                            top = 16.dp,
                            bottom = 6.dp
                        ).align(Alignment.Start)
                    )
                }
            }
        }
    }
}