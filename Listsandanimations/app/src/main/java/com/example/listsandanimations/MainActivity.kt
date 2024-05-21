@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    val borderColor = animateColorAsState(
            targetValue = if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            animationSpec = tween(durationMillis = 300)
    )

    ComposeTutorialTheme {
        Surface(
                modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable { isExpanded = !isExpanded },
                shape = MaterialTheme.shapes.medium,
                elevation = if (isExpanded) 16.dp else 4.dp
        ) {
            Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                        painter = painterResource(id = message.profilePicture),
                        contentDescription = null,
                        modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .border(1.5.dp, borderColor.value, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                        modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize(
                                        animationSpec = spring(
                                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                                stiffness = Spring.StiffnessLow
                                        )
                                )
                ) {
                    Text(
                            text = message.author,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(
                            modifier = Modifier.animateContentSize(),
                            shape = MaterialTheme.shapes.medium,
                            color = if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                    ) {
                        Text(
                                text = message.content,
                                color = if (isExpanded) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(all = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(
                messages = listOf(
                        Message(
                                author = "Android",
                                content = "Hi, this is a sample message!",
                                profilePicture = R.drawable.profile_picture
                        ),
                        Message(
                                author = "Jetpack Compose",
                                content = "Jetpack Compose is a modern, efficient, and declarative UI toolkit for building native Android apps.",
                                profilePicture = R.drawable.profile_picture
                        ),
                        Message(
                                author = "Material Design",
                                content = "Material Design is a comprehensive guide for visual, motion, and interaction design across platforms and devices.",
                                profilePicture = R.drawable.profile_picture
                        )
                )
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT)
@Composable
fun PreviewConversationDark() {
    ComposeTutorialTheme {
        Conversation(
                messages = listOf(
                        Message(
                                author = "Android",
                                content = "Hi, this is a sample message!",
                                profilePicture = R.drawable.profile_picture
                        ),
                        Message(
                                author = "Jetpack Compose",
                                content = "Jetpack Compose is a modern, efficient, and declarative UI toolkit for building native Android apps.",
                                profilePicture = R.drawable.profile_picture
                        ),
                        Message(
                                author = "Material Design",
                                content = "Material Design is a comprehensive guide for visual, motion, and interaction design across platforms and devices.",
                                profilePicture = R.drawable.profile_picture
                        )
                )
        )
    }
}