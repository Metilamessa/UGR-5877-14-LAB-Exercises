fun findMax(numbers: List<Int>): Int? {
    return numbers.maxOrNull()
}

fun filterEvenNumbers(numbers: List<Int>): List<Int> {
    return numbers.filter { it % 2 == 0 }
}

fun calculateAverage(numbers: List<Double>): Double? {
    if (numbers.isEmpty()) {
        return null
    }
    val sum = numbers.sum()
    return sum / numbers.size
}

fun main() {
    println("Enter a list of numbers (space-separated):")
    val input = readLine()?.trim()

    val numbers = input?.split("\\s+".toRegex())?.mapNotNull { it.toDoubleOrNull() }

    if (numbers.isNullOrEmpty()) {
        println("Invalid input. Please enter a list of numbers.")
        return
    }

    val max = findMax(numbers)
    println("Maximum value: $max")

    val evenNumbers = filterEvenNumbers(numbers)
    println("Even numbers: $evenNumbers")

    val average = calculateAverage(numbers)
    println("Average: $average")
}