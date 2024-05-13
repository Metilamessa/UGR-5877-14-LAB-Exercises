fun main() {
    println("Enter the first number:")
    val number1 = readLine()?.toDoubleOrNull() ?: return

    println("Enter the second number:")
    val number2 = readLine()?.toDoubleOrNull() ?: return

    println("Enter the operation (addition, subtraction, multiplication, division):")
    val operation = readLine()

    val result = when (operation) {
        "addition" -> number1 + number2
        "subtraction" -> number1 - number2
        "multiplication" -> number1 * number2
        "division" -> number1 / number2
        else -> {
            println("Invalid operation")
            return
        }
    }

    println("Result of $operation: $result")
}