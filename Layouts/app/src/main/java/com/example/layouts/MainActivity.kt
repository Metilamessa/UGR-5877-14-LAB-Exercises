data class Message(
        val author: String,
        val content: String,
        val profilePicture: Int
)

@Composable
fun MessageCard(message: Message) {
    Row(
            modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
    ) {
        Image(
                painter = painterResource(id = message.profilePicture),
                contentDescription = null,
                modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                    text = message.author,
                    fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = message.content)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    val message = Message(
            author = "Android",
            content = "Hi, this is a sample message!",
            profilePicture = R.drawable.profile_picture
    )
    MessageCard(message = message)
}