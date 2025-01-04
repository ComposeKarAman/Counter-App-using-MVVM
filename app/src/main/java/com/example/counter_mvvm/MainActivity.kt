package com.example.counter_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counter_mvvm.ui.theme.CounterMVVMTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                val viewModel : CounterViewModel = viewModel()

                CounterMVVMTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        TheCounterApp(
                            modifier = Modifier.padding(innerPadding), viewModel
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun TheCounterApp(modifier: Modifier = Modifier, viewModel: CounterViewModel) {
        Column(
            modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Counter App",
                Modifier.padding(30.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )

            Column(
                modifier.fillMaxSize(),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {

                Text(viewModel.getCount.value.toString(), style = MaterialTheme.typography.displayLarge)

                Row(Modifier.padding(24.dp)) {
                    Button({ viewModel.onIncrement() }) {
                        Text("Increment")
                    }

                    Spacer(Modifier.width(16.dp))

                    Button({ viewModel.onDecrement() }) {
                        Text("Decrement")
                    }
                }
                Button( { viewModel.onRest() }) {
                    Text("Reset")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun CounterPreview() {
        TheCounterApp(Modifier, viewModel())
    }
