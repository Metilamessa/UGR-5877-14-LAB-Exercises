@Composable
fun MessageCard(message: Message) {
    ComposeTutorialTheme {
        Surface(
                modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                elevation = 4.dp
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
                                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                            text = message.author,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                            text = message.content,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        MessageCard(
                message = Message(
                        author = "Android",
                        content = "Hi, this is a sample message!",
                        profilePicture = R.drawable.profile_picture
                )
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT)
@Composable
fun PreviewMessageCardDark() {
    ComposeTutorialTheme {
        MessageCard(
                message = Message(
                        author = "Android",
                        content = "Hi, this is a sample message!",
                        profilePicture = R.drawable.profile_picture
                )
        )
    }
}