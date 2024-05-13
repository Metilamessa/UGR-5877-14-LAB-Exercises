fun generateRandomPassword(length: Int): String {
    val charPool = listOf(
        "abcdefghijklmnopqrstuvwxyz",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "0123456789",
        "!@#$%^&*()-_=+[]{}"
    ).joinToString("")

    val password = StringBuilder(length)

    val random = java.util.Random()
    repeat(length) {
        val randomIndex = random.nextInt(charPool.length)
        val randomChar = charPool[randomIndex]
        password.append(randomChar)
    }

    return password.toString()
}

fun main() {
    println("Enter the desired password length:")
    val length = readLine()?.toIntOrNull() ?: return

    if (length <= 0) {
        println("Invalid password length.")
        return
    }

    val password = generateRandomPassword(length)

    println("Generated password: $password")
}