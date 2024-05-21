class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp()
        }
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
                text = count.toString(),
                fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                    onClick = { count++ }
            ) {
                Text("Increment")
            }

            Button(
                    onClick = { count-- }
            ) {
                Text("Decrement")
            }

            Button(
                    onClick = { count = 0 }
            ) {
                Text("Reset")
            }
        }
    }
}