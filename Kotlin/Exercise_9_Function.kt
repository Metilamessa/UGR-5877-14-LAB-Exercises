fun applyUppercaseTransformation(strings: List<String>): List<String> {
    return strings.map { it.toUpperCase() }
}

fun filterNumbersGreaterThan(numbers: List<Int>, value: Int): List<Int> {
    return numbers.filter { it > value }
}

fun calculateSum(numbers: List<Int>): Int {
    return numbers.reduce { sum, element -> sum + element }
}

fun main() {
    println("Enter a list of strings:")
    val input = readLine()
    val strings = input?.split(",")?.map { it.trim() } ?: emptyList()

   
    val transformedStrings = applyUppercaseTransformation(strings)
    println("Transformed strings: $transformedStrings")

    println("Enter a list of integers:")
    val inputNumbers = readLine()
    val numbers = inputNumbers?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: emptyList()

    println("Enter a value for filtering:")
    val filterValue = readLine()?.toIntOrNull()

    if (filterValue != null) {
        val filteredNumbers = filterNumbersGreaterThan(numbers, filterValue)
        println("Filtered numbers: $filteredNumbers")

        val sum = calculateSum(numbers)
        println("Sum: $sum")
    } else {
        println("Invalid filter value.")
    }
}